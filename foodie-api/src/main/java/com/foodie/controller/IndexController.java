package com.foodie.controller;


import com.foodie.YesOrNo;
import com.foodie.pojo.Carousel;
import com.foodie.pojo.Users;
import com.foodie.pojo.bo.UserBo;
import com.foodie.service.CarouselService;
import com.foodie.service.UsersService;
import com.foodie.utils.CookieUtils;
import com.foodie.utils.JSONResult;
import com.foodie.utils.JsonUtils;
import com.foodie.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("index")
@Api(value = "首页",tags = {"首页展示的相关接口"})
public class IndexController {

    @Autowired
    private CarouselService carouselService;


    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONResult carousel(){
        return JSONResult.ok(carouselService.queryAll(YesOrNo.YES.type));

    }

    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类，渲染展示到首页
     * 2. 如果鼠标上移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载（懒加载）
     */




}
