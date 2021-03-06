package com.ebeijia.zl.core.activemq.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ebeijia.zl.common.utils.domain.SmsVo;
import com.ebeijia.zl.core.activemq.service.MQProducerService;
import com.ebeijia.zl.core.activemq.vo.WechatCustomerParam;
import com.ebeijia.zl.core.activemq.vo.WechatTemplateParam;
import com.ebeijia.zl.core.redis.utils.RedisConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.TreeMap;

/**
 * 
 * @author zqy
 * @description 队列消息生产者，发送消息到队列
 * 
 */
@Service("mqProducerService")
public class MQProducerServiceImpl implements MQProducerService {

	private Logger logger = LoggerFactory.getLogger(MQProducerServiceImpl.class);

	@Autowired
	private JedisCluster jedisCluster;

	/**
	 * 微信客服消息
	 */
	@Autowired
	@Qualifier("consumerMsgJmsTemplate")
	private JmsTemplate consumerMsgJmsTemplate;

	/**
	 * 微信模板消息
	 */
	@Autowired
	@Qualifier("templateMsgJmsTemplate")
	private JmsTemplate templateMsgJmsTemplate;

	@Autowired
	@Qualifier("rechargeMobileJmsTemplate")
	private JmsTemplate rechargeMobileJmsTemplate;

	@Autowired
	@Qualifier("smsMsgJmsTemplate")
	private JmsTemplate smsMsgJmsTemplate;

	/**
	 * 发送微信客服消息
	 * 
	 * @param param
	 */
	public void sendMessage(final WechatCustomerParam param) {
		consumerMsgJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(param));
			}
		});
	}

	/**
	 * 发送微信客服消息
	 * 
	 * @param acountName
	 *            公众号
	 * @param notice
	 *            消息内容
	 * @param toOpenId
	 *            用户openId
	 */
	public void sendWechatMessage(String acountName, String notice, String toOpenId) {
		WechatCustomerParam wechantParam = new WechatCustomerParam();
		wechantParam.setAcountName(acountName);
		wechantParam.setToOpenId(toOpenId);
		wechantParam.setContent(notice);
		this.sendMessage(wechantParam);
	}

	public void setConsumerMsgJmsTemplate(JmsTemplate consumerMsgJmsTemplate) {
		this.consumerMsgJmsTemplate = consumerMsgJmsTemplate;
	}

	public JmsTemplate getConsumerMsgJmsTemplate() {
		return consumerMsgJmsTemplate;
	}

	public void setTemplateMsgJmsTemplate(JmsTemplate templateMsgJmsTemplate) {
		this.templateMsgJmsTemplate = templateMsgJmsTemplate;
	}

	/**
	 * 微信公众号 模板消息推送
	 * 
	 * @param acountName
	 *            微信公众号
	 * @param touser
	 *            目标用户openId
	 * @param template_id
	 *            模板Id
	 * @param url
	 *            页面跳转url
	 * @param data
	 *            消息模板数据
	 */
	public void sendTemplateMsg(String acountName, String touser, String template_id, String url,
			TreeMap<String, TreeMap<String, String>> data) {
		WechatTemplateParam templateParam = new WechatTemplateParam();
		templateParam.setAcountName(acountName);
		templateParam.setTouser(touser);
		templateParam.setTemplate_id(template_id);
		templateParam.setData(data);
		templateParam.setUrl(url);
		this.sendTemplateMsg(templateParam);
	}

	/**
	 * 微信公众号 模板消息推送
	 * 
	 * @param templateParam
	 */
	public void sendTemplateMsg(final WechatTemplateParam templateParam) {
		templateMsgJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(templateParam));
			}
		});
	}

	/**
	 * @param channelOrderId 分销商话费充值订单号
	 */
	public void sendRechargeMobileMsg(final String channelOrderId){
		logger.info("channelOrderId={}",channelOrderId);
		rechargeMobileJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(channelOrderId);
			}
		});
	}

	/**
	 * 短信发送
	 * @param smsVo
	 */
	public void sendSMS(final SmsVo smsVo){
		String msg=JSONArray.toJSONString(smsVo);
		logger.info("sendSMS={}",msg);
		//短信开关 Y：可发短信; N: 不可发短信
		if("Y".equals(jedisCluster.hget(RedisConstants.REDIS_HASH_TABLE_TB_BASE_DICT_KV,"SMS_SWITCH_FLAG"))){
			smsMsgJmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(msg);
				}
			});
		}
	}
}
