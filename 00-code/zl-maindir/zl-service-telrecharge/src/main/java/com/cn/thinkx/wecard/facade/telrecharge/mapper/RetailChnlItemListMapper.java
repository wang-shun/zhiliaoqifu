package com.cn.thinkx.wecard.facade.telrecharge.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.thinkx.wecard.facade.telrecharge.domain.RetailChnlItemList;

@Mapper
public interface RetailChnlItemListMapper extends BaseMapper<RetailChnlItemList> {

	int deleteByProductId(String id);
	
	
	List<RetailChnlItemList> getList();
}
