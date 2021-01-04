package com.foodie.controller;

import com.foodie.pojo.Users;
import com.foodie.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(Users)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@RestController
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;


}