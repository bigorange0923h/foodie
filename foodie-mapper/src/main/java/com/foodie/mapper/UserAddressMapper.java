package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressMapper extends MyMapper<UserAddress> {
}