package com.foodie.pojo;

import java.io.Serializable;

/**
 * 商品分类(Category)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 820594290001168455L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 分类名称
    */
    private String name;
    /**
    * 分类类型
    */
    private Integer type;
    /**
    * 父id
    */
    private Integer fatherId;
    /**
    * 图标
    */
    private String logo;
    /**
    * 口号
    */
    private String slogan;
    /**
    * 分类图
    */
    private String catImage;
    /**
    * 背景颜色
    */
    private String bgColor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

}