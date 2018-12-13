package com.ebeijia.zl.basics.order.service.impl;

import com.ebeijia.zl.basics.order.domain.PlatfOrder;
import com.ebeijia.zl.basics.order.mapper.PlatfOrderMapper;
import com.ebeijia.zl.basics.order.service.PlatfOrderService;
import com.ebeijia.zl.common.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("platfOrderService")
public class PlatfOrderServiceImpl extends BaseServiceImpl<PlatfOrder> implements PlatfOrderService {

	@Autowired
	private PlatfOrderMapper platfOrderMapper;

	@Override
	public List<PlatfOrder> getPlatfOrderList(PlatfOrder po) {
		return platfOrderMapper.getPlatfOrderList(po);
	}

	@Override
	public String getPrimaryKey() {
		return platfOrderMapper.getPrimaryKey();
	}

	@Override
	public List<PlatfOrder> getPlatfOrderGoodsByMemberId(PlatfOrder po) {
		return platfOrderMapper.getPlatfOrderGoodsByMemberId(po);
	}

	@Override
	public int updateOlatfOrder() {
		return platfOrderMapper.updateOlatfOrder();
	}

}