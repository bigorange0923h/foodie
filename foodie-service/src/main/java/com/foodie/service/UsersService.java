package com.foodie.service;

import com.foodie.pojo.Users;
import com.foodie.pojo.bo.UserBo;

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

    Users createUser(UserBo userBo);

    /**
     * 检索用户名与密码是否匹配,用于登录
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username,String password);
}