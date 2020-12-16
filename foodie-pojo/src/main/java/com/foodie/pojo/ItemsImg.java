package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品图片(ItemsImg)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public class ItemsImg implements Serializable {
    private static final long serialVersionUID = 475604051001513836L;
    /**
    * 图片主键
    */
    private String id;
    /**
    * 商品外键id 商品外键id
    */
    private String itemId;
    /**
    * 图片地址 图片地址
    */
    private String url;
    /**
    * 顺序 图片顺序，从小到大
    */
    private Integer sort;
    /**
    * 是否主图 是否主图，1：是，0：否
    */
    private Integer isMain;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
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