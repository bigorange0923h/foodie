package com.foodie.controller;

import com.foodie.pojo.bo.AddressBO;
import com.foodie.service.UserAddressService;
import com.foodie.utils.JSONResult;
import com.foodie.utils.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value="地址相关",tags={"地址相关的API接口"})
@RestController
@RequestMapping("/address")
public class AddressController extends  BaseController{

    @Autowired
    UserAddressService userAddressService;



    @ApiOperation(value = "根据用户ID查找地址列表", notes = "根据用户ID查找地址列表数据", httpMethod = "POST")
    @PostMapping("/list")
    public JSONResult addressList(
            @ApiParam(name = "userId", value = "','用户ID", required = true)
            @RequestParam String userId
    ) {

        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("未获取到地址列表");
        }
        return JSONResult.ok(userAddressService.queryAll(userId));
    }


    @ApiOperation(value = "新增用户地址", notes = "新增用户地址", httpMethod = "POST")
    @PostMapping("/add")
    public JSONResult addUserAddress(@RequestBody AddressBO addressBO) {

        JSONResult jsonResult = checkAddress(addressBO);
        if(jsonResult.getStatus() != 200){
            return  jsonResult;
        }
        userAddressService.addNewAddress(addressBO);
        return JSONResult.ok();
    }


    @ApiOperation(value = "修改用户地址", notes = "修改用户地址", httpMethod = "POST")
    @PostMapping("/update")
    public JSONResult update(@RequestBody AddressBO addressBO) {
        if(StringUtils.isBlank(addressBO.getAddressId())){
            return  JSONResult.errorMsg("修改地址错误:addressId 不能为空!");
        }
        JSONResult jsonResult = checkAddress(addressBO);
        if(jsonResult.getStatus() != 200){
            return  jsonResult;
        }
        userAddressService.updateNewAddress(addressBO);
        return JSONResult.ok();
    }


    @ApiOperation(value = "删除用户地址", notes = "删除用户地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JSONResult delete(
            @ApiParam(name = "userId", value = "','用户ID", required = true)
            @RequestParam String userId,
            @ApiParam(name = "addressId", value = "','地址ID", required = true)
            @RequestParam String addressId

    ) {
        if(StringUtils.isBlank(addressId)){
            return  JSONResult.errorMsg("删除失败:addressId不能为空");
        }
        if(StringUtils.isBlank(userId)){
            return  JSONResult.errorMsg("删除失败:userId不能为空");
        }
        userAddressService.deleteUserAddress(userId,addressId);
        return JSONResult.ok();
    }

    @ApiOperation(value = "设置默认地址", notes = "设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public JSONResult setDefalut(
            @ApiParam(name = "userId", value = "','用户ID", required = true)
            @RequestParam String userId,
            @ApiParam(name = "addressId", value = "','地址ID", required = true)
            @RequestParam String addressId

    ) {
        if(StringUtils.isBlank(addressId)){
            return  JSONResult.errorMsg("设置失败:addressId不能为空");
        }
        if(StringUtils.isBlank(userId)){
            return  JSONResult.errorMsg("设置失败:userId不能为空");
        }
        userAddressService.updateAddressToBeDefault(userId,addressId);
        return JSONResult.ok();
    }



    /**
     * 校验参数
     * @param addressBO
     * @return
     */
    private JSONResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return JSONResult.errorMsg("收货人不能为空");
        }
        if (receiver.length() > 12) {
            return JSONResult.errorMsg("收货人姓名不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return JSONResult.errorMsg("收货人手机号不能为空");
        }
        if (mobile.length() != 11) {
            return JSONResult.errorMsg("收货人手机号长度不正确");
        }
        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return JSONResult.errorMsg("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        if (StringUtils.isBlank(province) ||
                StringUtils.isBlank(city) ||
                StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail)) {
            return JSONResult.errorMsg("收货地址信息不能为空");
        }

        return JSONResult.ok();
    }
}
