package com.foodie.service.impl;

import com.foodie.enums.YesOrNo;
import com.foodie.mapper.UserAddressMapper;
import com.foodie.pojo.UserAddress;
import com.foodie.pojo.bo.AddressBO;
import com.foodie.service.UserAddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private Sid sid;

    @Transactional(propagation =  Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return mapper.select(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewAddress(AddressBO addressBO) {

        //判断当前用户是否存在地址,如果没有则新增为默认地址;
        int isDefault = 0;
        List<UserAddress> userAddresses = this.queryAll(addressBO.getUserId());
        if(userAddresses == null|| userAddresses.size() == 0){
            isDefault = 1;
        }
        //保存地址至数据库
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,userAddress);
        userAddress.setId(sid.nextShort());
        userAddress.setIsDefault(isDefault);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        mapper.insert(userAddress);


    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateNewAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();
        UserAddress pendingAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO,pendingAddress);
        pendingAddress.setId(addressId);
        pendingAddress.setUpdatedTime(new Date());
        mapper.updateByPrimaryKeySelective(pendingAddress);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);
        mapper.delete(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateAddressToBeDefault(String userId, String addressId) {
        //查找默认地址设置为不默认
        //若地址ID为需修改默认状态的地址ID则更新
        List<UserAddress> userAddresses = this.queryAll(userId);
        for (UserAddress address : userAddresses) {
            address.setIsDefault(YesOrNo.NO.type);
            if(addressId.equals(address.getId())){
                address.setIsDefault(YesOrNo.YES.type);
            }
            mapper.updateByPrimaryKeySelective(address);
        }


    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserAddress queryUserAddress(String userId, String addressId) {
        UserAddress singleAddress = new UserAddress();
        singleAddress.setId(addressId);
        singleAddress.setUserId(userId);
        return  mapper.selectOne(singleAddress);
    }
}