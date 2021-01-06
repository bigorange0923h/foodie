package com.foodie.mapper;

import com.foodie.my.mapper.MyMapper;
import com.foodie.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends MyMapper<Users> {
    //void usernameIsExist(String userName);
}