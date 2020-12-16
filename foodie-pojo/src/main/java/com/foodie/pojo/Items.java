package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public class Items implements Serializable {
    private static final long serialVersionUID = -98514119593264206L;
    /**
    * 商品主键id
    */
    private String id;
    /**
    * 商品名称 商品名称
    */
    private String itemName;
    /**
    * 分类外键id 分类id
    */
    private Integer catId;
    /**
    * 一级分类外键id
    */
    private Integer rootCatId;
    /**
    * 累计销售 累计销售
    */
    private Integer sellCounts;
    /**
    * 上下架状态 上下架状态,1:上架 2:下架
    */
    private Integer onOffStatus;
    /**
    * 商品内容 商品内容
    */
    private String content;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public Integer getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(Integer sellCounts) {
        this.sellCounts = sellCounts;
    }

    public Integer getOnOffStatus() {
        return onOffStatus;
    }

    public void setOnOffStatus(Integer onOffStatus) {
        this.onOffStatus = onOffStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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