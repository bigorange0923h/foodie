package com.foodie.pojo;

import java.io.Serializable;

/**
 * 订单商品关联表(OrderItems)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public class OrderItems implements Serializable {
    private static final long serialVersionUID = 147005758394543934L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 归属订单id
    */
    private String orderId;
    /**
    * 商品id
    */
    private String itemId;
    /**
    * 商品图片
    */
    private String itemImg;
    /**
    * 商品名称
    */
    private String itemName;
    /**
    * 规格id
    */
    private String itemSpecId;
    /**
    * 规格名称
    */
    private String itemSpecName;
    /**
    * 成交价格
    */
    private Integer price;
    /**
    * 购买数量
    */
    private Integer buyCounts;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    public String getItemSpecName() {
        return itemSpecName;
    }

    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

}