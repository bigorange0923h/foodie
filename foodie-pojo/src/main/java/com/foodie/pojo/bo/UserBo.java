package com.foodie.pojo.bo;

import lombok.Data;

@Data
public class UserBo {
    private String  username;
    private String  password;
    private String  confirmPassword;
}
