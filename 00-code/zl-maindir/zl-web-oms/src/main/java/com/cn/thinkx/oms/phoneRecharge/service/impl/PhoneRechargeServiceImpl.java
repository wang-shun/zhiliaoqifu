package com.cn.thinkx.oms.phoneRecharge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONObject;
import com.cn.thinkx.ecom.redis.core.utils.JedisClusterUtils;
import com.cn.thinkx.oms.phoneRecharge.mapper.PhoneRechargeMapper;
import com.cn.thinkx.oms.phoneRecharge.model.PhoneRechargeOrder;
import com.cn.thinkx.oms.phoneRecharge.model.PhoneRechargeOrderUpload;
import com.cn.thinkx.oms.phoneRecharge.req.PhoneRechargeRefundReq;
import com.cn.thinkx.oms.phoneRecharge.resp.PhoneRechargeRefundResp;
import com.cn.thinkx.oms.phoneRecharge.service.PhoneRechargeService;
import com.ebeijia.zl.common.utils.constants.Constants;
import com.ebeijia.zl.common.utils.constants.Constants.ChannelCode;
import com.ebeijia.zl.common.utils.enums.TelRechargeConstants.phoneRechargeOrderType;
import com.ebeijia.zl.common.utils.enums.TelRechargeConstants.phoneRechargeReqChnl;
import com.ebeijia.zl.common.utils.enums.TelRechargeConstants.phoneRechargeSupplier;
import com.ebeijia.zl.common.utils.enums.TelRechargeConstants.phoneRechargeTransStat;
import com.ebeijia.zl.common.utils.enums.TelRechargeConstants.refundFalg;
import com.ebeijia.zl.common.utils.http.HttpClientUtil;
import com.ebeijia.zl.common.utils.tools.NumberUtils;
import com.ebeijia.zl.common.utils.tools.SignUtil;
import com.ebeijia.zl.common.utils.tools.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("phoneRechargeService")
public class PhoneRechargeServiceImpl implements PhoneRechargeService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PhoneRechargeMapper phoneRechargeMapper;
	
	@Autowired
	private JedisClusterUtils jedisClusterUtils;

	@Override
	public PageInfo<PhoneRechargeOrder> getPhoneRechargeListPage(int startNum, int pageSize,
			PhoneRechargeOrder entity) {
		PageHelper.startPage(startNum, pageSize);
		List<PhoneRechargeOrder> list = phoneRechargeMapper.getPhoneRechargeList(entity);
		if (list != null && list.size() > 0) {
			for (PhoneRechargeOrder phoneRechargeOrder : list) {
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrder.getSupplier()))
					phoneRechargeOrder.setSupplier(phoneRechargeSupplier.findByCode(phoneRechargeOrder.getSupplier()).getValue());
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrder.getTransStat()))
					phoneRechargeOrder.setTransStat(phoneRechargeTransStat.findByCode(phoneRechargeOrder.getTransStat()).getValue());
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrder.getOrderType()))
					phoneRechargeOrder.setOrderType(phoneRechargeOrderType.findByCode(phoneRechargeOrder.getOrderType()).getValue());
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrder.getReqChannel()))
					phoneRechargeOrder.setReqChannel(phoneRechargeReqChnl.findByCode(phoneRechargeOrder.getReqChannel()).getValue());
				phoneRechargeOrder.setTransAmt(StringUtil.isNullOrEmpty(phoneRechargeOrder.getTransAmt()) ? "0": NumberUtils.RMBCentToYuan(phoneRechargeOrder.getTransAmt()));
				phoneRechargeOrder.setTelephoneFace(StringUtil.isNullOrEmpty(phoneRechargeOrder.getTelephoneFace())? "0" : phoneRechargeOrder.getTelephoneFace());
				phoneRechargeOrder.setDiscountsAmt(StringUtil.isNullOrEmpty(phoneRechargeOrder.getDiscountsAmt()) ? "0": phoneRechargeOrder.getDiscountsAmt());
				phoneRechargeOrder.setSupplierAmt(StringUtil.isNullOrEmpty(phoneRechargeOrder.getSupplierAmt()) ? "0": phoneRechargeOrder.getSupplierAmt());
				phoneRechargeOrder.setFluxFace(StringUtil.isNullOrEmpty(phoneRechargeOrder.getFluxFace()) ? "0": phoneRechargeOrder.getFluxFace());
			}
		}
		PageInfo<PhoneRechargeOrder> page = new PageInfo<PhoneRechargeOrder>(list);
		return page;
	}

	@Override
	public List<PhoneRechargeOrderUpload> getPhoneRechargeList(PhoneRechargeOrder entity) {
		List<PhoneRechargeOrderUpload> proList = phoneRechargeMapper.getPhoneRechargeListUpload(entity);
		if (proList != null && proList.size() > 0) {
			for (PhoneRechargeOrderUpload phoneRechargeOrderUpload : proList) {
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getSupplier()))
					phoneRechargeOrderUpload.setSupplier(phoneRechargeSupplier.findByCode(phoneRechargeOrderUpload.getSupplier()).getValue());
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getTransStat()))
					phoneRechargeOrderUpload.setTransStat(phoneRechargeTransStat.findByCode(phoneRechargeOrderUpload.getTransStat()).getValue());
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getOrderType()))
					phoneRechargeOrderUpload.setOrderType(phoneRechargeOrderType.findByCode(phoneRechargeOrderUpload.getOrderType()).getValue());
				if (!StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getReqChannel()))
					phoneRechargeOrderUpload.setReqChannel(phoneRechargeReqChnl.findByCode(phoneRechargeOrderUpload.getReqChannel()).getValue());
				phoneRechargeOrderUpload.setTransAmt(StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getTransAmt())? "0" : NumberUtils.RMBCentToYuan(phoneRechargeOrderUpload.getTransAmt()));
				phoneRechargeOrderUpload.setTelephoneFace(StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getTelephoneFace()) ? "0": phoneRechargeOrderUpload.getTelephoneFace());
				phoneRechargeOrderUpload.setDiscountsAmt(StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getDiscountsAmt()) ? "0": phoneRechargeOrderUpload.getDiscountsAmt());
				phoneRechargeOrderUpload.setSupplierAmt(StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getSupplierAmt()) ? "0": phoneRechargeOrderUpload.getSupplierAmt());
				phoneRechargeOrderUpload.setFluxFace(StringUtil.isNullOrEmpty(phoneRechargeOrderUpload.getFluxFace())? "0" : phoneRechargeOrderUpload.getFluxFace());
			}
		}
		return proList;
	}

	@Override
	public String doPhoneRechargeRefund(String rId) {
		ModelMap resultMap = new ModelMap();
		resultMap.addAttribute("status", Boolean.FALSE);
		resultMap.addAttribute("msg", "退款失败");
		try {
			if (StringUtil.isNullOrEmpty(rId)) {
				return JSONObject.toJSONString(resultMap);
			}
			PhoneRechargeOrder phoneRechargeOrder = phoneRechargeMapper.getPhoneRechargeByRid(rId);
			String key = jedisClusterUtils.hget("TB_BASE_DICT_KV", "PHONE_RECHARGE_REQ_KEY");
			PhoneRechargeRefundReq req = new PhoneRechargeRefundReq();
			req.setOriOrderId(phoneRechargeOrder.getrId());
			req.setRefundOrderId(phoneRechargeOrder.getrId());
			req.setRefundAmount(phoneRechargeOrder.getTransAmt());
			req.setChannel(ChannelCode.CHANNEL8.toString());// 40007001
			req.setRefundFlag(refundFalg.refundFalg1.getCode());
			req.setTimestamp(System.currentTimeMillis());
			req.setSign(SignUtil.genSign(req, key));
			String url = jedisClusterUtils.hget("TB_BASE_DICT_KV", "PHONE_RECHARGE_REFUND");
			String result = HttpClientUtil.sendPostReturnStr(url, JSONObject.toJSONString(req));// 发起退款请求
			logger.info("## 退款请求参数，[{}]，退款返回参数[{}]", JSONObject.toJSONString(req), result);
			PhoneRechargeRefundResp resp = JSONObject.parseObject(result, PhoneRechargeRefundResp.class);
			if (Constants.SUCCESS_CODE.equals(resp.getCode())) {
				phoneRechargeOrder.setTransStat(phoneRechargeTransStat.PRTS5.getCode());
				resultMap.addAttribute("status", Boolean.TRUE);
				resultMap.addAttribute("msg", "退款成功");
			} else {
				phoneRechargeOrder.setTransStat(phoneRechargeTransStat.PRTS6.getCode());
			}
			phoneRechargeMapper.updatePhoneRechargeOrder(phoneRechargeOrder);// 更新订单信息
		} catch (Exception e) {
			logger.error("## 支付渠道是福利余额的手机充值退款异常", e);
			resultMap.addAttribute("status", Boolean.FALSE);
			resultMap.addAttribute("msg", "退款失败");
		}
		return JSONObject.toJSONString(resultMap);
	}

}