package com.ebeijia.zl.shop.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ApiModel("转账信息")
@Data
@ToString
public class DealInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("源账户类型，目前只有托管账户可以转账")
    String sourceType;

    @ApiModelProperty("目标账户类型")
    String targetType;

    @ApiModelProperty("源账户ID")
    String sourceAccountId;

    @ApiModelProperty("目标账户ID")
    String targetAccountId;

    @ApiModelProperty("单位分，转账金额")
    Long amount;
}
