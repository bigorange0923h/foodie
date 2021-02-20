package com.foodie.service;

import com.foodie.pojo.UserAddress;
import com.foodie.pojo.bo.AddressBO;

import java.util.List;

/**
 * 用户地址表(UserAddress)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public interface UserAddressService {



    List<UserAddress> queryAll(String userId);

    void addNewAddress(AddressBO addressBO);

    void updateNewAddress(AddressBO addressBO);

    void deleteUserAddress(String userId, String addressId);

    void updateAddressToBeDefault(String userId, String addressId);
}