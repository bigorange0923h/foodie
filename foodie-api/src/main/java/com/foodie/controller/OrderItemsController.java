package com.foodie.controller;

import com.foodie.pojo.OrderItems;
import com.foodie.service.OrderItemsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单商品关联表(OrderItems)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@RestController
@RequestMapping("orderItems")
public class OrderItemsController {
    /**
     * 服务对象
     */
    @Resource
    private OrderItemsService orderItemsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderItems selectOne(String id) {
        return this.orderItemsService.queryById(id);
    }

}