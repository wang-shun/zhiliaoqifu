package com.ebeijia.zl.shop.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

/**
 * 用于包装账户认证中心返回的令牌信息
 */
@ApiModel("令牌信息")
@Data
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
//    private String userId;

    public Token(String token) {
        this.token = token;
//        this.userId = userId;
    }
}
