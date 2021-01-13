package com.foodie.controller;

import com.foodie.pojo.bo.ShopcartBO;
import com.foodie.service.StuService;
import com.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value="购物车接口",tags = {"购物车相关接口"})
@RestController
public class ShopController {

    final static Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    StuService stuService;


    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public JSONResult add(
            @RequestParam String userId,
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        if(StringUtils.isBlank(userId)){
            return JSONResult.errorMsg("");
        }
        System.out.println(shopcartBO);
        // TODO 前端用户在登录的情况下添加商品到购物车会同步添加到redis缓存

        return JSONResult.ok();
    }



}
