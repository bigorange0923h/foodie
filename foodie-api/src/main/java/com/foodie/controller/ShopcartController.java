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
@RequestMapping("shopcart")
public class ShopcartController {

    final static Logger logger = LoggerFactory.getLogger(ShopcartController.class);

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


    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public JSONResult del(
            @RequestParam String userId,
            @RequestParam String itemSpecId,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)){
            return JSONResult.errorMsg("参数不能为空");
        }

        // TODO 用户在页面删除购物车中的商品数据,如果用户已经登录,则需要同步删除后端购物车中的商品

        return JSONResult.ok();
    }



}
