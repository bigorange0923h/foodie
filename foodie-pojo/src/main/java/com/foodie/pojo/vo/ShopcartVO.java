package com.foodie.pojo.vo;

import lombok.Data;

/**
 * 购物车渲染类
 */
@Data
public class ShopcartVO {

    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;
}
