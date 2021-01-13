package com.foodie.service;

import com.foodie.pojo.Items;
import com.foodie.pojo.ItemsImg;
import com.foodie.pojo.ItemsParam;
import com.foodie.pojo.ItemsSpec;
import com.foodie.pojo.vo.CommentLevelCountsVO;
import com.foodie.pojo.vo.ItemCommentVO;
import com.foodie.pojo.vo.ShopcartVO;
import com.foodie.utils.PagedGridResult;

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


    /**
     * 根据商品ID查询商品的评价
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 根据分类ID搜索商品
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(Integer catId, String sort, Integer page, Integer pageSize);

    /**
     * 根据ids查询并且刷新购物车中最新的商品信息
     * @param specIds
     * @return
     */
    public List<ShopcartVO> queryItemsBySpecIds(String specIds);
}