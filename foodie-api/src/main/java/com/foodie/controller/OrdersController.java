package com.foodie.controller;

import com.foodie.enums.PayMethod;
import com.foodie.pojo.bo.SubmitOrderBO;
import com.foodie.service.OrdersService;
import com.foodie.utils.CookieUtils;
import com.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 订单表;(Orders)表控制层
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
@Api(value = "订单相关", tags = {"订单相关的接口"})
@RestController
@RequestMapping("orders")
public class OrdersController extends  BaseController{

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "用户下单", notes = "用户下单",httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(@RequestBody SubmitOrderBO submitOrderBO,
                             HttpServletRequest request,
                             HttpServletResponse response
    ) {

        if(submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
                && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type){
            return JSONResult.errorMsg("支付方式不支持!");
        }
        //1.创建订单
          String orderId =   ordersService.create(submitOrderBO);
        //2.创建订单后,移除购物车中已经结算(已提交)的商品
        //TODO 整合redis 之后,完善购物车中的已结算的商品清除,并且同步带前端的Cookie
        //CookieUtils.setCookie(request,response,FOODIE_SHOPCART,"",true);
        //3.向支付中心传送订单数据,用于保存支付中心订单数据
        return JSONResult.ok(orderId);
    }

}