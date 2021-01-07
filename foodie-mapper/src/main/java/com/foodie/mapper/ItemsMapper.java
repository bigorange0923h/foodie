package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.Items;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsMapper extends MyMapper<Items> {
}