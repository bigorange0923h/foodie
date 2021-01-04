package com.foodie.service.impl;

import com.foodie.enums.Sex;
import com.foodie.mapper.UsersMapper;

import com.foodie.pojo.Users;
import com.foodie.pojo.bo.UserBo;
import com.foodie.service.UsersService;
import com.foodie.utils.DateUtil;
import com.foodie.utils.MD5Utils;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

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

    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    @Override
    public boolean usernameIsExist(String userName) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", userName);
        Users result = usersMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBo userBo) {

        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBo.getUsername());
        try{
        user.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        }catch ( Exception e){
            e.printStackTrace();
        }
        //用户默认属性
        user.setNickname(userBo.getUsername());
        user.setFace(USER_FACE);
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }
}