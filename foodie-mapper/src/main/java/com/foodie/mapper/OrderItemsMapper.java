package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.OrderItems;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsMapper extends MyMapper<OrderItems> {
}