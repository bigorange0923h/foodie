package com.foodie.service;

import com.foodie.pojo.Items;
import com.foodie.pojo.ItemsImg;
import com.foodie.pojo.ItemsParam;
import com.foodie.pojo.ItemsSpec;
import com.foodie.pojo.vo.CommentLevelCountsVO;

import java.util.List;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public interface ItemsService {

    /**
     * 根据商品ID查询详情
     * @param id
     * @return
     */
    public Items queryItemsById(String id);

    /**
     * 根据商品ID查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemsImgList(String itemId);

    /**
     * 根据商品ID查询商品规格
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemsSpecList(String itemId);

    /**
     * 根据商品ID查询参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemsParam(String itemId);

    /**
     * 根据商品ID查询商品的评价等级数量
     * @param itemId
     */
    public CommentLevelCountsVO queryCommentCounts(String itemId);


}