package com.foodie.service;

import com.foodie.pojo.Orders;
import com.foodie.pojo.bo.SubmitOrderBO;


import java.util.List;

/**
 * 订单表;(Orders)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public interface OrdersService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    String create(SubmitOrderBO submitOrderBO);
}