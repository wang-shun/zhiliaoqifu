package com.ebeijia.zl.basics.order.service;

import com.ebeijia.zl.basics.order.domain.EcomRefundAddress;
import com.ebeijia.zl.common.core.service.BaseService;

public interface EcomRefundAddressService extends BaseService<EcomRefundAddress> {

	/**
	 * 保存退货地址
	 * 
	 * @param entity
	 */
	void saveEcomRefundAddress(EcomRefundAddress entity);
	
	/**
	 * 通过退款申请id查询退货地址信息
	 * 
	 * @param returnsId
	 * @return
	 */
	EcomRefundAddress selectByReturnsId(String returnsId);
}