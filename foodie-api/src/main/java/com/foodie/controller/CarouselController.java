package com.foodie.controller;

import com.foodie.pojo.Carousel;
import com.foodie.service.CarouselService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 轮播图(Carousel)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:43:58
 */
@RestController
@RequestMapping("carousel")
public class CarouselController {
    /**
     * 服务对象
     */
    @Resource
    private CarouselService carouselService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Carousel selectOne(String id) {
        return this.carouselService.queryById(id);
    }

}