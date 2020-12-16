package com.foodie.mapper;

import com.foodie.pojo.OrderStatus;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单状态表;订单的每个状态更改都需要进行记录
10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）
退货/退货，此分支流程不做，所以不加入(OrderStatus)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public interface OrderStatusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    OrderStatus queryById(String orderId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderStatus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderStatus 实例对象
     * @return 对象列表
     */
    List<OrderStatus> queryAll(OrderStatus orderStatus);

    /**
     * 新增数据
     *
     * @param orderStatus 实例对象
     * @return 影响行数
     */
    int insert(OrderStatus orderStatus);

    /**
     * 修改数据
     *
     * @param orderStatus 实例对象
     * @return 影响行数
     */
    int update(OrderStatus orderStatus);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(String orderId);

}