package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品参数(ItemsParam)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public class ItemsParam implements Serializable {
    private static final long serialVersionUID = 696831034007700629L;
    /**
    * 商品参数id
    */
    private String id;
    /**
    * 商品外键id
    */
    private String itemId;
    /**
    * 产地 产地，例：中国江苏
    */
    private String producPlace;
    /**
    * 保质期 保质期，例：180天
    */
    private String footPeriod;
    /**
    * 品牌名 品牌名，例：三只大灰狼
    */
    private String brand;
    /**
    * 生产厂名 生产厂名，例：大灰狼工厂
    */
    private String factoryName;
    /**
    * 生产厂址 生产厂址，例：大灰狼生产基地
    */
    private String factoryAddress;
    /**
    * 包装方式 包装方式，例：袋装
    */
    private String packagingMethod;
    /**
    * 规格重量 规格重量，例：35g
    */
    private String weight;
    /**
    * 存储方法 存储方法，例：常温5~25°
    */
    private String storageMethod;
    /**
    * 食用方式 食用方式，例：开袋即食
    */
    private String eatMethod;
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

    public String getProducPlace() {
        return producPlace;
    }

    public void setProducPlace(String producPlace) {
        this.producPlace = producPlace;
    }

    public String getFootPeriod() {
        return footPeriod;
    }

    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getPackagingMethod() {
        return packagingMethod;
    }

    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public String getEatMethod() {
        return eatMethod;
    }

    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod;
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