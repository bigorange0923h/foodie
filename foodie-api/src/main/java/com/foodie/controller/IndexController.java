package com.foodie.controller;


import com.foodie.enums.YesOrNo;
import com.foodie.service.CarouselService;
import com.foodie.service.CategoryService;
import com.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("index")
@Api(value = "首页",tags = {"首页展示的相关接口"})
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

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

    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public JSONResult cats(){
        return JSONResult.ok(categoryService.queryAllRootLevelCat());
    }

    @ApiOperation(value = "获取商品分类(子分类)", notes = "获取商品分类(子分类)", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public JSONResult subCat(
            @ApiParam(name="rootCatId",value = "一级分类ID",required = true)
            @PathVariable Integer rootCatId){
        if(rootCatId == null){
             return JSONResult.errorMsg("分类不存在");
        }
        return JSONResult.ok(categoryService.getSubCatList(rootCatId));
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品", notes = "查询每个一级分类下的最新6条商品", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public JSONResult sixNewItemsLazy(
            @ApiParam(name="rootCatId",value = "一级分类ID",required = true)
            @PathVariable Integer rootCatId){
        if(rootCatId == null){
             return JSONResult.errorMsg("分类不存在");
        }
        return JSONResult.ok(categoryService.getSixNewItemsLazy(rootCatId));
    }



}
