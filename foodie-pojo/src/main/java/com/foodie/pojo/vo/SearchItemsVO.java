package com.foodie.pojo.vo;

import lombok.Data;

/**
 * 用于展示商品搜索列表结果的VO
 */
@Data
public class SearchItemsVO {
    private String itemId;
    private String itemName;
    private int sellCounts;
    private String imgUrl;
    private int price;
}
