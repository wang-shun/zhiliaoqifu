package com.ebeijia.zl.basics.order.service.impl;

import com.ebeijia.zl.basics.order.domain.ReturnsInf;
import com.ebeijia.zl.basics.order.domain.ReturnsOrder;
import com.ebeijia.zl.basics.order.mapper.ReturnsOrderMapper;
import com.ebeijia.zl.basics.order.service.ReturnsOrderService;
import com.ebeijia.zl.common.core.service.impl.BaseServiceImpl;
import com.ebeijia.zl.common.utils.constants.Constants;
import com.ebeijia.zl.common.utils.tools.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("returnsOrderService")
public class ReturnsOrderServiceImpl extends BaseServiceImpl<ReturnsOrder> implements ReturnsOrderService {

	@Autowired
	private ReturnsOrderMapper returnsOrderMapper;
	
	@Override
	public List<ReturnsOrder> getReturnsOrderList(ReturnsOrder returnsOrder) {
		return returnsOrderMapper.getReturnsOrderList(returnsOrder);
	}

	@Override
	public List<ReturnsOrder> getReturnsOrderListByReturnsOrder(ReturnsOrder returnsOrder) {
		return returnsOrderMapper.getReturnsOrderListByReturnsOrder(returnsOrder);
	}
	
	@Override
	public List<ReturnsOrder> getReturnsOrderBySorderId(String sOrderId) {
		return returnsOrderMapper.getReturnsOrderBySorderId(sOrderId);
	}

	@Override
	public ReturnsOrder getReturnsOrderByReturnsId(String returnsId) {
		return returnsOrderMapper.getReturnsOrderByReturnsId(returnsId);
	}

	@Override
	public ReturnsInf getReturnsInfByItemId(String itemId) {
		return returnsOrderMapper.getReturnsInfByItemId(itemId);
	}

	@Override
	public ReturnsOrder getReturnsOrderByApplyId(ReturnsOrder returnsOrder) {
		return returnsOrderMapper.getReturnsOrderByApplyId(returnsOrder);
	}

	@Override
	public ReturnsOrder getReturnsOrderByItemId(ReturnsOrder returnsOrder) {
		ReturnsOrder rOrder = returnsOrderMapper.getReturnsOrderByItemId(returnsOrder);
		if(rOrder!=null){
			rOrder.setRetType(Constants.returnType.findByCode(rOrder.getApplyReasonType()).getValue());
			rOrder.setProductPrice(NumberUtils.RMBCentToYuan(rOrder.getProductPrice()));
			rOrder.setResv1(NumberUtils.RMBCentToYuan(rOrder.getResv1()));
			rOrder.setApplyReturnType(Constants.ApplyReturnState.findByCode(rOrder.getApplyReturnState()).getValue());
		}
		return rOrder;
	}

}