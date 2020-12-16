package com.foodie.service.impl;

import com.foodie.mapper.UserAddressDao;
import com.foodie.pojo.UserAddress;
import com.foodie.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户地址表(UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddressDao userAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserAddress queryById(String id) {
        return this.userAddressDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserAddress> queryAllByLimit(int offset, int limit) {
        return this.userAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userAddress 实例对象
     * @return 实例对象
     */
    @Override
    public UserAddress insert(UserAddress userAddress) {
        this.userAddressDao.insert(userAddress);
        return userAddress;
    }

    /**
     * 修改数据
     *
     * @param userAddress 实例对象
     * @return 实例对象
     */
    @Override
    public UserAddress update(UserAddress userAddress) {
        this.userAddressDao.update(userAddress);
        return this.queryById(userAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userAddressDao.deleteById(id) > 0;
    }
}