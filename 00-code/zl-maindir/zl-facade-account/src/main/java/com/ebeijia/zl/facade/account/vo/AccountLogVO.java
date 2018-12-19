package com.ebeijia.zl.facade.account.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
public class AccountLogVO {

    /**
     * 交易流水主键
     */
   private String txnPrimaryKey;

    /**
     * 交易日期
     */
    private String txnDate;

    /**
     * 交易时间
     */
    private String txnTime;
    /**
     * 交易类型 0：开户 1：加款 2：减款
     */
    private String accType;

    /**
     * 交易金额
     */
    private BigDecimal txnAmt;

    /**
     * 交易后余额
     */
    private BigDecimal accTotalBal;

    /**
     * 交易描述
     */
    private String transDesc;

    /**
     * 交易数量
     */
    private String transNumber;

    /**
     * 交易类型
     */
    private String transId;

    /**
     * 专项类型
     */
    private String priBId;

    /**
     * 商户主键
     */
    private String mchntCode;

    /**
     * 商户名称
     */
    private String mchntName;

  /***
  * 用户类型
  */
 private String userType;

}