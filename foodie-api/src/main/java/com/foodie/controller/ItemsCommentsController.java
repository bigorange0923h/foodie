package com.foodie.controller;

import com.foodie.pojo.ItemsComments;
import com.foodie.service.ItemsCommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品评价表(ItemsComments)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@RestController
@RequestMapping("itemsComments")
public class ItemsCommentsController {
    /**
     * 服务对象
     */
    @Resource
    private ItemsCommentsService itemsCommentsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ItemsComments selectOne(String id) {
        return this.itemsCommentsService.queryById(id);
    }

}