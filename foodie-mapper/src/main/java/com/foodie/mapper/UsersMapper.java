package com.foodie.mapper;

import com.foodie.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends MyMapper<Users> {
    //void usernameIsExist(String userName);
}