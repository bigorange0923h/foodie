package com.foodie.service.impl;

import com.foodie.mapper.UsersMapper;
import com.foodie.pojo.Users;
import com.foodie.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户表(Users)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    public UsersMapper usersMapper;

    @Override
    public boolean usernameIsExist(String userName) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", userName);
        Users result = usersMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }
}