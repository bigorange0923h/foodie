package com.foodie.controller;

import com.foodie.pojo.Category;
import com.foodie.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品分类(Category)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Category selectOne(Integer id) {
        return this.categoryService.queryById(id);
    }

}