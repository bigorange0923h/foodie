package com.foodie.service;

import com.foodie.pojo.ItemsParam;
import java.util.List;

/**
 * 商品参数(ItemsParam)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public interface ItemsParamService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItemsParam queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItemsParam> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itemsParam 实例对象
     * @return 实例对象
     */
    ItemsParam insert(ItemsParam itemsParam);

    /**
     * 修改数据
     *
     * @param itemsParam 实例对象
     * @return 实例对象
     */
    ItemsParam update(ItemsParam itemsParam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}