package com.foodie.controller;

import com.foodie.pojo.Items;
import com.foodie.service.ItemsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@RestController
@RequestMapping("items")
public class ItemsController {
    /**
     * 服务对象
     */
    @Resource
    private ItemsService itemsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Items selectOne(String id) {
        return this.itemsService.queryById(id);
    }

}