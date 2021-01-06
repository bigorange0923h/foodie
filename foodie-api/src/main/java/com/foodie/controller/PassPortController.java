package com.foodie.controller;


import com.foodie.pojo.Users;
import com.foodie.pojo.bo.UserBo;
import com.foodie.service.UsersService;
import com.foodie.utils.CookieUtils;
import com.foodie.utils.JSONResult;
import com.foodie.utils.JsonUtils;
import com.foodie.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("passport")
@Api(value = "注册登录",tags = {"用于注册登录接口"})
public class PassPortController {

    @Autowired
    UsersService usersService;


    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String  userName){
        if(StringUtils.isBlank(userName)){
            return JSONResult.errorMsg("用户名不能为空!");
        }else if(usersService.usernameIsExist(userName)){
            return JSONResult.errorMsg("用户名已存在!");
        }else{
            return JSONResult.ok();
        }
    }



    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBo userBo,HttpServletRequest request,
                             HttpServletResponse response){


        //判断用户名和密码是否为空
        if(StringUtils.isBlank(userBo.getUsername())  ||
                StringUtils.isBlank(userBo.getPassword())   ||
                StringUtils.isBlank(userBo.getConfirmPassword())){
            return  JSONResult.errorMsg("用户名或者密码不能为空!");
        }
        //判断用户名和密码是否为空
        if(!userBo.getPassword().equals(userBo.getConfirmPassword())){
            return  JSONResult.errorMsg("两次密码不一致");
        }
        //判断密码长度
        if(userBo.getPassword().length() <6 || userBo.getPassword().length() > 18){
            return  JSONResult.errorMsg("密码长度至少大于6位,小于18位");
        }
        //判断密码是否一致
        if(!userBo.getPassword().equals(userBo.getConfirmPassword())){
            return  JSONResult.errorMsg("两次密码不一致");
        }
        if(usersService.usernameIsExist(userBo.getUsername())){
            return JSONResult.errorMsg("用户名已存在!");
        }
        Users user = usersService.createUser(userBo);
        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(setNullProperty(user)),true);

        return  JSONResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBo userBo, HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        //判断用户名和密码是否为空
        if(StringUtils.isBlank(userBo.getUsername())  ||
                StringUtils.isBlank(userBo.getPassword()) ){
            return  JSONResult.errorMsg("用户名或者密码不能为空!");
        }

        //判断密码长度
        if(userBo.getPassword().length() <6 || userBo.getPassword().length() > 18){
            return  JSONResult.errorMsg("密码长度至少大于6位,小于18位");
        }

        //实现登录
        Users users = usersService.queryUserForLogin(userBo.getUsername(), MD5Utils.getMD5Str(userBo.getPassword()));
        if (users == null){
            return JSONResult.errorMsg("用户名或者密码不正确!");
        }
        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(setNullProperty(users)),true);

        return  JSONResult.ok(users);
    }

    @ApiOperation(value = "退出登录", notes = "退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestBody String userId, HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        //清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request,response,"user");
        return  JSONResult.ok();
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }


}
