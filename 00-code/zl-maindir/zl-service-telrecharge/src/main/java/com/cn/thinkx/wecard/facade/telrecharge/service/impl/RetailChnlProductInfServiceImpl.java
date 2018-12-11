package com.cn.thinkx.wecard.facade.telrecharge.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.thinkx.wecard.facade.telrecharge.domain.RetailChnlProductInf;
import com.cn.thinkx.wecard.facade.telrecharge.enums.TelRechargeConstants;
import com.cn.thinkx.wecard.facade.telrecharge.mapper.RetailChnlProductInfMapper;
import com.cn.thinkx.wecard.facade.telrecharge.service.RetailChnlProductInfService;
import com.ebeijia.zl.common.utils.tools.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 *
 * 分销商充值产品管理表 Service 实现类
 *
 * @User zhuqi
 * @Date 2018-12-10
 */
@Service
public class RetailChnlProductInfServiceImpl extends ServiceImpl<RetailChnlProductInfMapper, RetailChnlProductInf> implements RetailChnlProductInfService{
	


	@Autowired
	private RetailChnlProductInfMapper retailChnlProductInfMapper;



	/**
	 * 保存对象返回ID
	 * 
	 * @param RetailChnlProductInf
	 * @return
	 * @throws Exception
	 */
	public String saveRetailChnlProductForId(RetailChnlProductInf RetailChnlProductInf) throws Exception {
		int oper = retailChnlProductInfMapper.insert(RetailChnlProductInf);
		if (oper > 0) {
			return RetailChnlProductInf.getProductId();
		} else {
			return "";
		}
	}




	/**
	 * 获取分销商产品的折扣
	 * 
	 * @return maps -->productId:产品编号, operId:运营商，productType: 类型，
	 *         areaName:地区名称，productAmt:产品面额（3位小数）
	 */
	public RetailChnlProductInf getProductRateByMaps(Map maps) {
		return retailChnlProductInfMapper.getProductRateByMaps(maps);
	}

	public List<RetailChnlProductInf> getRetailChnlProductInfList(RetailChnlProductInf retailChnlProductInf) {
		return retailChnlProductInfMapper.getList(retailChnlProductInf);
	}

	
	public PageInfo<RetailChnlProductInf> getRetailChnlProductInfPage(int startNum, int pageSize,RetailChnlProductInf RetailChnlProductInf){
		PageHelper.startPage(startNum, pageSize);
		List<RetailChnlProductInf> RetailChnlProductInfList = getRetailChnlProductInfList(RetailChnlProductInf);
		for (RetailChnlProductInf RetailChnlProductInf2 : RetailChnlProductInfList) {
			if (!StringUtil.isNullOrEmpty(RetailChnlProductInf2.getOperId()))
				RetailChnlProductInf2
						.setOperId(TelRechargeConstants.OperatorType.findByCode(RetailChnlProductInf2.getOperId()));
			if (!StringUtil.isNullOrEmpty(RetailChnlProductInf2.getProductType()))
				RetailChnlProductInf2.setProductType(
						TelRechargeConstants.ChannelProductProType.findByCode(RetailChnlProductInf2.getProductType()));
			if (!StringUtil.isNullOrEmpty(RetailChnlProductInf2.getAreaFlag()))
				RetailChnlProductInf2.setAreaFlag(
						TelRechargeConstants.ChannelProductAreaFlag.findByCode(RetailChnlProductInf2.getAreaFlag()));
		}
		PageInfo<RetailChnlProductInf> telProviderInfPage = new PageInfo<RetailChnlProductInf>(
				RetailChnlProductInfList);
		return telProviderInfPage;
	}

	
	public List<RetailChnlProductInf> getChannelProductListByChannelId(String channelId) {
		return retailChnlProductInfMapper.getChannelProductListByChannelId(channelId);
	}

	
	public RetailChnlProductInf getChannelProductByItemId(String id) {
		return retailChnlProductInfMapper.getChannelProductByItemId(id);
	}




	@Override
	public List<RetailChnlProductInf> getList(RetailChnlProductInf retailChnlProductInf) {
		// TODO Auto-generated method stub
		return retailChnlProductInfMapper.getList(retailChnlProductInf);
	}


}
