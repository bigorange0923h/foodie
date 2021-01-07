package com.foodie.pojo.vo;

import lombok.Data;

/**
 * 用于展示商品评价数量的VO
 */
@Data
public class CommentLevelCountsVO {

    private Integer totalCounts;
    private Integer goodCounts;
    private Integer normalCounts;
    private Integer badCounts;

}
