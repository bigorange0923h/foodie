package com.foodie.controller;

import com.foodie.pojo.ItemsParam;
import com.foodie.service.ItemsParamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品参数(ItemsParam)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@RestController
@RequestMapping("itemsParam")
public class ItemsParamController {
    /**
     * 服务对象
     */
    @Resource
    private ItemsParamService itemsParamService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ItemsParam selectOne(String id) {
        return this.itemsParamService.queryById(id);
    }

}