package com.foodie.controller;


import com.foodie.service.UsersService;
import com.foodie.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passport")
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
}
