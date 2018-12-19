package com.ebeijia.zl.shop.vo;

import com.ebeijia.zl.shop.dao.order.domain.TbEcomOrderProductItem;
import com.ebeijia.zl.shop.dao.order.domain.TbEcomOrderShip;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel("订单详情信息")
@Data
public class EcomOrderDetailInfo {


    @ApiModelProperty(value = "order_id")
    private String orderId;

    @ApiModelProperty(value = "member_id")
    private String memberId;

    @ApiModelProperty(value = "dms_related_key")
    private String dmsRelatedKey;

    /**
     * 0：未付款
     1：已付款待确认
     2：已付款
     3：已退款
     4：部分退款
     5：部分付款
     8：已取消
     9：已完成
     */
    @ApiModelProperty(value = "0：未付款                        1：已付款待确认                        2：已付款                        3：已退款                        4：部分退款                        5：部分付款                        8：已取消                        9：已完成")
    private String payStatus;

    /**
     * 单位：分（不含运费）
     */
    @ApiModelProperty(value = "单位：分（不含运费）")
    private Integer orderPrice;

    /**
     * 单位：分
     */
    @ApiModelProperty(value = "单位：分")
    private Integer orderFreightAmt;

    @ApiModelProperty(value = "pay_type")
    private String payType;

    @ApiModelProperty(value = "pay_amt")
    private Integer payAmt;

    @ApiModelProperty(value = "pay_time")
    private Long payTime;

    @ApiModelProperty(value = "data_stat")
    private String dataStat;

    @ApiModelProperty(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "create_time")
    private Long createTime;

    @ApiModelProperty(value = "update_time")
    private Long updateTime;

    @ApiModelProperty(value = "order_channel")
    private String orderChannel;

    @ApiModelProperty(value = "ship info")
    TbEcomOrderShip ship;

    @ApiModelProperty(value = "订单的商品列表")
    List<TbEcomOrderProductItem> itemList;

}
