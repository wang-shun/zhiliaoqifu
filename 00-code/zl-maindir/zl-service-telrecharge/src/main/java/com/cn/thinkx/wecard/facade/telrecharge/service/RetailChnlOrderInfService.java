package com.cn.thinkx.wecard.facade.telrecharge.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.thinkx.wecard.facade.telrecharge.domain.RetailChnlOrderInf;
import com.cn.thinkx.wecard.facade.telrecharge.resp.TeleRespDomain;
import com.cn.thinkx.wecard.facade.telrecharge.resp.TeleRespVO;
import com.github.pagehelper.PageInfo;


/**
 *
 * 分销商信息表 Service 接口类
 *
 * @User zhuqi
 * @Date 2018-12-10
 */
public interface RetailChnlOrderInfService extends IService<RetailChnlOrderInf> {
	

	/**
	 * 分销商话费充值扣款
	 * @param RetailChnlOrderInf
	 * @param operId
	 * @param areaName
	 * @return
	 * @throws Exception
	 */
	TeleRespDomain<TeleRespVO> proChannelOrder(RetailChnlOrderInf retailChnlOrderInf,String operId,String areaName) throws Exception;
	
	List<RetailChnlOrderInf> getRetailChnlOrderInfList(RetailChnlOrderInf  retailChnlOrderInf) throws Exception;
	
	void doRechargeMobileMsg(String channelOrderId);
	
	/**
	 *  分销商 根据外部订单查询
	 * @param outerId
	 * @param channelId
	 * @return
	 * @throws Exception
	 */
	RetailChnlOrderInf getRetailChnlOrderInfByOuterId(String outerId,String channelId) throws Exception;
	
	/**
	 * 分销商订单分页列表
	 * @param startNum
	 * @param pageSize
	 * @param RetailChnlOrderInf
	 * @return  Exception
	 */
     PageInfo<RetailChnlOrderInf> getRetailChnlOrderInfPage(int startNum, int pageSize, RetailChnlOrderInf RetailChnlOrderInf) throws Exception;
     
     PageInfo<RetailChnlOrderInf> getRetailChnlOrderInf(int startNum, int pageSize, RetailChnlOrderInf RetailChnlOrderInf) throws Exception;
     
//     List<RetailChnlOrderInfUpload> getRetailChnlOrderInfListToUpload(RetailChnlOrderInf order);
     
     RetailChnlOrderInf getRetailChnlOrderInfCount(RetailChnlOrderInf order);

}
