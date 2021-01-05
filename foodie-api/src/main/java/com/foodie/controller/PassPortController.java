package com.foodie.controller;


import com.foodie.pojo.bo.UserBo;
import com.foodie.service.UsersService;
import com.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("passport")
@Api(value = "注册登录",tags = {"用于注册登录接口"})
public class PassPortController {

    @Autowired
    UsersService usersService;



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


    /**
     * 用户注册
     * @param userBo
     * @return
     */
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBo userBo){


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
            usersService.createUser(userBo);
        return  JSONResult.ok();
    }



}
