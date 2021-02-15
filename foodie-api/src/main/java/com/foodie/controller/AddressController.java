package com.foodie.controller;

import com.foodie.service.UserAddressService;
import com.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value="地址相关",tags={"地址相关的API接口"})
@RestController
@RequestMapping("/address")
public class AddressController extends  BaseController{

    @Autowired
    UserAddressService userAddressService;



    @ApiOperation(value = "根据用户ID查找地址列表", notes = "根据用户ID查找地址列表数据", httpMethod = "GET")
    @GetMapping("/list")
    public JSONResult addressList(
            @ApiParam(name = "userId", value = "','用户ID", required = true)
            @RequestParam String userId
    ) {

        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("未获取到地址列表");
        }
        return JSONResult.ok(userAddressService.queryAll(userId));
    }

}
