package com.foodie.service;

import com.foodie.pojo.Users;
import java.util.List;

/**
 * 用户表(Users)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public interface UsersService {

    /**
     * 查询当前用户名是否已存在
     * 
     * @param userName
     * @return
     */
    boolean usernameIsExist(String userName);
}