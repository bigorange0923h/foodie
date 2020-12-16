package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计(ItemsSpec)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public class ItemsSpec implements Serializable {
    private static final long serialVersionUID = 586121012544481917L;
    /**
    * 商品规格id
    */
    private String id;
    /**
    * 商品外键id
    */
    private String itemId;
    /**
    * 规格名称
    */
    private String name;
    /**
    * 库存
    */
    private Integer stock;
    /**
    * 折扣力度
    */
    private Double discounts;
    /**
    * 优惠价
    */
    private Integer priceDiscount;
    /**
    * 原价
    */
    private Integer priceNormal;
    /**
    * 创建时间
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }

    public Integer getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Integer priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Integer getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
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