package com.cn.thinkx.wecard.facade.telrecharge.facadeimpl;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.thinkx.wecard.facade.telrecharge.domain.RetailChnlInf;
import com.cn.thinkx.wecard.facade.telrecharge.service.RetailChnlInfFacade;
import com.cn.thinkx.wecard.facade.telrecharge.service.RetailChnlInfService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
@Service
public class RetailChnlInfFacadeImpl  implements RetailChnlInfFacade {

	@Autowired
	private RetailChnlInfService retailChnlInfService;
	
	@Override
	public RetailChnlInf getRetailChnlInfById(String channelId) throws Exception {
		return retailChnlInfService.getById(channelId);
	}

	@Override
	public boolean saveRetailChnlInf(RetailChnlInf RetailChnlInf) throws Exception {
		 return retailChnlInfService.save(RetailChnlInf);
	}

	@Override
	public boolean updateRetailChnlInf(RetailChnlInf RetailChnlInf) throws Exception {
		return retailChnlInfService.updateById(RetailChnlInf);
	}

	@Override
	public boolean deleteRetailChnlInfById(String channelId) throws Exception {
		return retailChnlInfService.removeById(channelId);
	}

	@Override
	public List<RetailChnlInf> getRetailChnlInfList(RetailChnlInf RetailChnlInf) throws Exception {
		return retailChnlInfService.getList(RetailChnlInf);
	}
//	
//	/**
//	 * 扣减的渠道金额
//	 * @param payAmt 订单金额，需扣减的金额
//	 * @return
//	 */
//	public int subChannelReserveAmt(String channelId,BigDecimal payAmt) throws Exception{
//		RetailChnlInf RetailChnlInf=this.getRetailChnlInfById(channelId);
//		if(RetailChnlInf.getChannelReserveAmt().compareTo(payAmt) ==-1){
//			return 0;
//		}
//		BigDecimal currReserveAmt =RetailChnlInf.getChannelReserveAmt().subtract(payAmt).setScale(3, BigDecimal.ROUND_DOWN);
//		RetailChnlInf.setChannelReserveAmt(currReserveAmt);
//		return this.updateRetailChnlInf(RetailChnlInf);
//	}

	@Override
	public PageInfo<RetailChnlInf> getRetailChnlInfPage(int startNum, int pageSize, RetailChnlInf entity) throws Exception {
		PageHelper.startPage(startNum, pageSize);
		List<RetailChnlInf> list = getRetailChnlInfList(entity);
		PageInfo<RetailChnlInf> page = new PageInfo<RetailChnlInf>(list);
		return page;
	}

//	@Override
//	public RetailChnlInf getRetailChnlInfByMchntCode(String mchntCode) throws Exception {
//		return retailChnlInfService.getRetailChnlInfByMchntCode(mchntCode);
//	}
}
