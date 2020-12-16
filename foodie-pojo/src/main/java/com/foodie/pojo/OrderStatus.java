package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单状态表;订单的每个状态更改都需要进行记录
10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）
退货/退货，此分支流程不做，所以不加入(OrderStatus)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 816703500407891484L;
    /**
    * 订单ID;对应订单表的主键id
    */
    private String orderId;
    /**
    * 订单状态
    */
    private Integer orderStatus;
    /**
    * 订单创建时间;对应[10:待付款]状态
    */
    private Date createdTime;
    /**
    * 支付成功时间;对应[20:已付款，待发货]状态
    */
    private Date payTime;
    /**
    * 发货时间;对应[30：已发货，待收货]状态
    */
    private Date deliverTime;
    /**
    * 交易成功时间;对应[40：交易成功]状态
    */
    private Date successTime;
    /**
    * 交易关闭时间;对应[50：交易关闭]状态
    */
    private Date closeTime;
    /**
    * 留言时间;用户在交易成功后的留言时间
    */
    private Date commentTime;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

}