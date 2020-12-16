package com.foodie.controller;

import com.foodie.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    StuService stuService;

    @GetMapping("/hello")
    public Object hello(){
        return "Hello world!";
    }

    @GetMapping("/getStu")
    public Object getStu(Integer id){
        return stuService.queryById(id);
    }
}
