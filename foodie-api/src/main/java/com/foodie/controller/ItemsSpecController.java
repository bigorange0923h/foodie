package com.foodie.controller;

import com.foodie.pojo.ItemsSpec;
import com.foodie.service.ItemsSpecService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计(ItemsSpec)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@RestController
@RequestMapping("itemsSpec")
public class ItemsSpecController {
    /**
     * 服务对象
     */
    @Resource
    private ItemsSpecService itemsSpecService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ItemsSpec selectOne(String id) {
        return this.itemsSpecService.queryById(id);
    }

}