package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表;(Orders)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = 173322953642422231L;
    /**
    * 订单主键;同时也是订单编号
    */
    private String id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 收货人快照
    */
    private String receiverName;
    /**
    * 收货人手机号快照
    */
    private String receiverMobile;
    /**
    * 收货地址快照
    */
    private String receiverAddress;
    /**
    * 订单总价格
    */
    private Integer totalAmount;
    /**
    * 实际支付总价格
    */
    private Integer realPayAmount;
    /**
    * 邮费;默认可以为零，代表包邮
    */
    private Integer postAmount;
    /**
    * 支付方式
    */
    private Integer payMethod;
    /**
    * 买家留言
    */
    private String leftMsg;
    /**
    * 扩展字段
    */
    private String extand;
    /**
    * 买家是否评价;1：已评价，0：未评价
    */
    private Integer isComment;
    /**
    * 逻辑删除状态;1: 删除 0:未删除
    */
    private Integer isDelete;
    /**
    * 创建时间（成交时间）
    */
    private Date createdTime;
    /**
    * 更新时间
    */
    private Date updatedTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getRealPayAmount() {
        return realPayAmount;
    }

    public void setRealPayAmount(Integer realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    public Integer getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(Integer postAmount) {
        this.postAmount = postAmount;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getLeftMsg() {
        return leftMsg;
    }

    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    public String getExtand() {
        return extand;
    }

    public void setExtand(String extand) {
        this.extand = extand;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}