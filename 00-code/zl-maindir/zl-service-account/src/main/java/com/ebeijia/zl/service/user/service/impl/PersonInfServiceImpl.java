package com.ebeijia.zl.service.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebeijia.zl.common.utils.enums.DataStatEnum;
import com.ebeijia.zl.facade.user.vo.PersonInf;
import com.ebeijia.zl.service.user.mapper.PersonInfMapper;
import com.ebeijia.zl.service.user.service.IPersonInfService;

/**
 *
 * 用户个人信息 Service 实现类
 *
 * @User zhuqi
 * @Date 2018-11-30
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor=Exception.class)
public class PersonInfServiceImpl extends ServiceImpl<PersonInfMapper, PersonInf> implements IPersonInfService{

	@Autowired
	private PersonInfMapper personInfMapper;
	
	@Override
	public boolean save(PersonInf entity){
		entity.setDataStat(DataStatEnum.TRUE_STATUS.getCode());
		entity.setCreateTime(System.currentTimeMillis());
		entity.setCreateUser("99999999");
		entity.setUpdateTime(System.currentTimeMillis());
		entity.setUpdateUser("99999999");
		entity.setLockVersion(0);
		return super.save(entity);
	}
	
	/**
	 * 根据手机号查找用户
	 * @param phoneNo
	 * @return
	 */
	public PersonInf getPersonInfByPhoneNo(String phoneNo){
		QueryWrapper<PersonInf> queryWrapper = new QueryWrapper<PersonInf>();
		queryWrapper.eq("mobile_phone_no", phoneNo);
		queryWrapper.eq("data_stat", DataStatEnum.TRUE_STATUS.getCode());
		return personInfMapper.selectOne(queryWrapper);
	}
}
