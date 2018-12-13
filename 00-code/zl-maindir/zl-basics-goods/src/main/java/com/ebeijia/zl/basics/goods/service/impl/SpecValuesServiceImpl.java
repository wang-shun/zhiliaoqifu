package com.ebeijia.zl.basics.goods.service.impl;

import com.ebeijia.zl.basics.goods.domain.SpecValues;
import com.ebeijia.zl.basics.goods.mapper.SpecValuesMapper;
import com.ebeijia.zl.basics.goods.service.SpecValuesService;
import com.ebeijia.zl.common.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("specValuesService")
public class SpecValuesServiceImpl extends BaseServiceImpl<SpecValues> implements SpecValuesService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SpecValuesMapper specValuesMapper;
	
	/**
	 * 查找规格值表
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public SpecValues getSpecValuesByRecord(SpecValues record) throws Exception{
		return specValuesMapper.getSpecValuesByRecord(record);
	}
	
	/**
	 * 保存规格值表
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public SpecValues saveSpecValues(SpecValues specValues) throws Exception{
		SpecValues record=specValuesMapper.getSpecValuesByRecord(specValues);
		if(record ==null){
			specValuesMapper.insert(specValues);
			record=specValues;
		}
		return record;
	}
	/**
	 * 查找所有的规格值信息表
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public List<SpecValues> getList(SpecValues record) throws Exception{
		return specValuesMapper.getList(record);
	}

	/**
	 * 查找商品的货品的规格值
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	public List<SpecValues> getGoodsSpecByGoodsId(String goodsId) throws Exception{
		return specValuesMapper.getGoodsSpecByGoodsId(goodsId);
	}
}