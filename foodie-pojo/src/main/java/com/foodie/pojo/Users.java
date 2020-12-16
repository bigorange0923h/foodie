package com.foodie.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(Users)实体类
 *
 * @author makejava
 * @since 2020-12-08 14:44:01
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 578640539533462214L;
    /**
    * 主键id 用户id
    */
    private String id;
    /**
    * 用户名 用户名
    */
    private String username;
    /**
    * 密码 密码
    */
    private String password;
    /**
    * 昵称 昵称
    */
    private String nickname;
    /**
    * 真实姓名
    */
    private String realname;
    /**
    * 头像
    */
    private String face;
    /**
    * 手机号 手机号
    */
    private String mobile;
    /**
    * 邮箱地址 邮箱地址
    */
    private String email;
    /**
    * 性别 性别 1:男  0:女  2:保密
    */
    private Integer sex;
    /**
    * 生日 生日
    */
    private Object birthday;
    /**
    * 创建时间 创建时间
    */
    private Date createdTime;
    /**
    * 更新时间 更新时间
    */
    private Date updatedTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}