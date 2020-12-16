package com.foodie.pojo;

import java.io.Serializable;

/**
 * (Stu)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public class Stu implements Serializable {
    private static final long serialVersionUID = 553242784384925311L;
    
    private Integer id;
    
    private String name;
    
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}