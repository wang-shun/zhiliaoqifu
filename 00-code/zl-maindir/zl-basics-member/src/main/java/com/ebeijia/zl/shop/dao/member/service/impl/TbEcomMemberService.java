package com.ebeijia.zl.shop.dao.member.service.impl;

import com.ebeijia.zl.shop.dao.member.domain.TbEcomMember;
import com.ebeijia.zl.shop.dao.member.mapper.TbEcomMemberMapper;
import com.ebeijia.zl.shop.dao.member.service.ITbEcomMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * 会员信息表 Service 实现类
 *
 * @User zl_shop
 * @Date 2018-12-26
 */
@Service
public class TbEcomMemberService extends ServiceImpl<TbEcomMemberMapper, TbEcomMember> implements ITbEcomMemberService{

    @Autowired
    private TbEcomMemberMapper ecomMemberMapper;

    @Override
    public List<TbEcomMember> getMemberInfList(TbEcomMember ecomMember) {
        return ecomMemberMapper.getMemberInfList(ecomMember);
    }
}
