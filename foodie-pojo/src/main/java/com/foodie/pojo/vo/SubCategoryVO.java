package com.foodie.pojo.vo;

import lombok.Data;

/**
 * 三级分类VO
 */
@Data
public class SubCategoryVO {
    private Integer subId;
    private String subName;
    private String subType;
    private Integer subFatherId;
}
