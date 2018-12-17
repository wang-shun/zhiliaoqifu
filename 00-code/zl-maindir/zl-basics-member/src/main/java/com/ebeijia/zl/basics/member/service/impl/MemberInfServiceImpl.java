package com.ebeijia.zl.basics.member.service.impl;

import com.ebeijia.zl.basics.member.domain.MemberInf;
import com.ebeijia.zl.basics.member.mapper.MemberInfMapper;
import com.ebeijia.zl.basics.member.service.MemberInfService;
import com.ebeijia.zl.common.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberInfService")
public class MemberInfServiceImpl extends BaseServiceImpl<MemberInf> implements MemberInfService {

	@Autowired
	private MemberInfMapper memberInfMapper;

	@Override
	public MemberInf getMemberInfByUserId(MemberInf entity) {
		return memberInfMapper.getMemberInfByUserId(entity);
	}

	/**
	 * 根据用户openId查找
	 * @param openId
	 * @return
	 */
	public	MemberInf getMemberInfByOpenId(String openId){
		MemberInf entity=new MemberInf();
		entity.setOpenId(openId);
		return this.getMemberInfByUserId(entity);
	}

	/**
	 * 知了企服用户 注册成为电商会员
	 * @param openId
	 * @return
	 * @throws Exception
	 */
	public	MemberInf RegMemberInfByOpenId(String openId) throws Exception{

		//查找当前openId是否已经注册
		MemberInf entity=this.getMemberInfByOpenId(openId);
		if(entity !=null){
			return entity;
		}
		return entity;
	}
}
