package com.foodie.service;

import com.foodie.pojo.ItemsSpec;
import java.util.List;

/**
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计(ItemsSpec)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public interface ItemsSpecService {

    /**
     * 根据规格ID查询商品规格信息
     * @param specId
     * @return
     */
    ItemsSpec queryItemSpecById(String specId);

    /**
     * 扣除商品库存
     * @param specId
     * @param buyCounts
     */
    public void  decreaseItemSpecStock(String specId,int buyCounts);
}