package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper extends MyMapper<Category> {
}