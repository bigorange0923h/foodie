package com.foodie.service;

import com.foodie.pojo.OrderItems;
import java.util.List;

/**
 * 订单商品关联表(OrderItems)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
public interface OrderItemsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderItems queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderItems> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderItems 实例对象
     * @return 实例对象
     */
    OrderItems insert(OrderItems orderItems);

    /**
     * 修改数据
     *
     * @param orderItems 实例对象
     * @return 实例对象
     */
    OrderItems update(OrderItems orderItems);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}