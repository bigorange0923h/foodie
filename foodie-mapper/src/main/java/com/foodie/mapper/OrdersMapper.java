package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.Orders;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersMapper extends MyMapper<Orders> {
}