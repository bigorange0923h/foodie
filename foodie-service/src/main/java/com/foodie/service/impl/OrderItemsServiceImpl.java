package com.foodie.service.impl;

import com.foodie.mapper.OrderItemsDao;
import com.foodie.pojo.OrderItems;
import com.foodie.service.OrderItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单商品关联表(OrderItems)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@Service("orderItemsService")
public class OrderItemsServiceImpl implements OrderItemsService {
    @Resource
    private OrderItemsDao orderItemsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderItems queryById(String id) {
        return this.orderItemsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderItems> queryAllByLimit(int offset, int limit) {
        return this.orderItemsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderItems 实例对象
     * @return 实例对象
     */
    @Override
    public OrderItems insert(OrderItems orderItems) {
        this.orderItemsDao.insert(orderItems);
        return orderItems;
    }

    /**
     * 修改数据
     *
     * @param orderItems 实例对象
     * @return 实例对象
     */
    @Override
    public OrderItems update(OrderItems orderItems) {
        this.orderItemsDao.update(orderItems);
        return this.queryById(orderItems.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.orderItemsDao.deleteById(id) > 0;
    }
}