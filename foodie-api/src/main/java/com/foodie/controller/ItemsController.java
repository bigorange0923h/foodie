package com.foodie.controller;

import com.foodie.pojo.Items;
import com.foodie.pojo.ItemsImg;
import com.foodie.pojo.ItemsParam;
import com.foodie.pojo.ItemsSpec;
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
public class ItemsController {

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
}