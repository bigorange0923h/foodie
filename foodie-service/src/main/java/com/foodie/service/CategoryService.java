package com.foodie.service;

import com.foodie.pojo.Category;
import com.foodie.pojo.vo.CategoryVO;
import com.foodie.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * 商品分类(Category)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public interface CategoryService {

    /**
     * 获取商品分类(一级分类)
     * @return
     */
    public List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类ID查询子分类
     * @param rootCatId
     * @return
     */
    public List <CategoryVO> getSubCatList(Integer rootCatId);


    /**
     * 查询首页每个一级分类的下的6条最新商品的数据
     * @param rootCatId
     * @return
     */
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}