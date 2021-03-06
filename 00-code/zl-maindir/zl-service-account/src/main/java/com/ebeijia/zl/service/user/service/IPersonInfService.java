package com.ebeijia.zl.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ebeijia.zl.facade.user.vo.PersonInf;


/**
 *
 * 用户个人信息 Service 接口类
 *
 * @User zhuqi
 * @Date 2018-11-30
 */
public interface IPersonInfService extends IService<PersonInf> {
	
	
	
	boolean save(PersonInf entity);
	/**
	 * 根据手机号查找用户
	 * @param phoneNo
	 * @return
	 */
	PersonInf getPersonInfByPhoneNo(String phoneNo);
}
