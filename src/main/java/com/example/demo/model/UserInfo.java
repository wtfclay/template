package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
     private Integer userId;
     private String userNo;
     private String userType;
     private String userName;
     private Date createTime;
}