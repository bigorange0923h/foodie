package com.foodie.service.impl;

import com.foodie.mapper.UserAddressMapper;
import com.foodie.pojo.UserAddress;
import com.foodie.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户地址表(UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper mapper;

    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return mapper.select(userAddress);
    }
}