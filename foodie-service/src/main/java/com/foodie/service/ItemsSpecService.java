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
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemsSpec queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemsSpec> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itemsSpec 实例对象
     * @return 实例对象
     */
    ItemsSpec insert(ItemsSpec itemsSpec);

    /**
     * 修改数据
     *
     * @param itemsSpec 实例对象
     * @return 实例对象
     */
    ItemsSpec update(ItemsSpec itemsSpec);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}