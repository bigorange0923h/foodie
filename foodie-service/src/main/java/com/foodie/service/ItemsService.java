package com.foodie.service;

import com.foodie.pojo.Items;
import java.util.List;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
public interface ItemsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Items queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Items> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param items 实例对象
     * @return 实例对象
     */
    Items insert(Items items);

    /**
     * 修改数据
     *
     * @param items 实例对象
     * @return 实例对象
     */
    Items update(Items items);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}