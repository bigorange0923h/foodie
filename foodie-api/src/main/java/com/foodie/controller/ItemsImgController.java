package com.foodie.controller;

import com.foodie.pojo.ItemsImg;
import com.foodie.service.ItemsImgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品图片(ItemsImg)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:00
 */
@RestController
@RequestMapping("itemsImg")
public class ItemsImgController {
    /**
     * 服务对象
     */
    @Resource
    private ItemsImgService itemsImgService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ItemsImg selectOne(String id) {
        return this.itemsImgService.queryById(id);
    }

}