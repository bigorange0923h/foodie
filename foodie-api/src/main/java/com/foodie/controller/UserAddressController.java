package com.foodie.controller;

import com.foodie.pojo.UserAddress;
import com.foodie.service.UserAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户地址表(UserAddress)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@RestController
@RequestMapping("userAddress")
public class UserAddressController {
    /**
     * 服务对象
     */
    @Resource
    private UserAddressService userAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserAddress selectOne(String id) {
        return this.userAddressService.queryById(id);
    }

}