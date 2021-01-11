package com.foodie.controller;

import com.foodie.pojo.Items;
import com.foodie.pojo.ItemsImg;
import com.foodie.pojo.ItemsParam;
import com.foodie.pojo.ItemsSpec;
import com.foodie.pojo.vo.CommentLevelCountsVO;
import com.foodie.pojo.vo.ItemInfoVO;
import com.foodie.service.ItemsService;
import com.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表(Items)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:43:59
 */
@RestController
@RequestMapping("items")
@Api(value = "商品接口",tags = {"商品信息展示的相关接口"})
public class ItemsController extends BaseController{

    @Autowired
    private ItemsService itemsService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JSONResult info(@ApiParam(name = "itemId",value = "商品ID",required = true)
                           @PathVariable String itemId){
        if(StringUtils.isBlank(itemId)){
            return JSONResult.errorMsg(null);
        }

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(itemsService.queryItemsById(itemId));
        itemInfoVO.setItemImgList(itemsService.queryItemsImgList(itemId));
        itemInfoVO.setItemParams(itemsService.queryItemsParam(itemId));
        itemInfoVO.setItemSpecList(itemsService.queryItemsSpecList(itemId));
        return JSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品商品评价等级", notes = "查询商品商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public JSONResult commentLevel(@ApiParam(name = "itemId",value = "商品ID",required = true)
                           @RequestParam String itemId){
        if(StringUtils.isBlank(itemId)){
            return JSONResult.errorMsg(null);
        }
        return JSONResult.ok(itemsService.queryCommentCounts(itemId));
    }

    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public JSONResult comments(
            @ApiParam(name = "itemId",value = "商品ID",required = true) @RequestParam String itemId,
            @ApiParam(name = "level",value = "评价等级",required = false) @RequestParam Integer level,
            @ApiParam(name = "page",value = "当前页数",required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "当前页数量",required = false) @RequestParam Integer pageSize
    ){

        if(StringUtils.isBlank(itemId)){
            return JSONResult.errorMsg(null);
        }
        if(page == null){
            page = COMMENT_PAGE;
        }
        if(pageSize == null){
            page =COMMENT_PAGE_SIZE;
        }
        return JSONResult.ok(itemsService.queryPagedComments(itemId,level,page,pageSize));
    }

    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @GetMapping("/search")
    public JSONResult search(
            @ApiParam(name = "keywords",value = "关键字",required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort",value = "排序",required = false)
            @RequestParam String sort,
            @ApiParam(name = "page",value = "当前页数",required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "当前页数量",required = false) @RequestParam Integer pageSize
    ){

        if(StringUtils.isBlank(keywords)){
            return JSONResult.errorMsg(null);
        }
        if(page == null){
            page = COMMENT_PAGE;
        }
        if(pageSize == null){
            page =COMMENT_PAGE_SIZE;
        }
        return JSONResult.ok(itemsService.searchItems(keywords,sort,page,pageSize));
    }


    @ApiOperation(value = "通过分类ID搜索商品列表", notes = "通过分类ID搜索商品列表", httpMethod = "GET")
    @GetMapping("/catItems")
    public JSONResult catItems(
            @ApiParam(name = "catId",value = "分类ID",required = true)
            @RequestParam Integer catId,
            @ApiParam(name = "sort",value = "排序",required = false)
            @RequestParam String sort,
            @ApiParam(name = "page",value = "当前页数",required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "当前页数量",required = false) @RequestParam Integer pageSize
    ){

        if(catId == null){
            return JSONResult.errorMsg(null);
        }
        if(page == null){
            page = COMMENT_PAGE;
        }
        if(pageSize == null){
            page =COMMENT_PAGE_SIZE;
        }
        return JSONResult.ok(itemsService.searchItems(catId,sort,page,pageSize));
    }
}