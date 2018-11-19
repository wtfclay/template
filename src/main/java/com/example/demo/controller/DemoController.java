package com.example.demo.controller;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.util.Column;
import com.example.demo.util.Table;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/get")
    public String get() {

        try {
            List<Column> columnList = Table.getColumnsInfo(jdbcTemplate.getDataSource().getConnection().getMetaData());

            //model(columnList);
            //mapping(columnList);
            //mapper();
            PageHelper.startPage(1,2);
            UserInfo u = new UserInfo();
            u.setUserName("1");
            List<UserInfo> userInfoList = userInfoMapper.selectList(u);
            PageInfo<UserInfo> page = new PageInfo<>(userInfoList);

        } catch (Exception e) {
            return e.getMessage();
        }

        return "success!";
    }
}
