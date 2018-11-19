package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    public UserInfo select(UserInfo userInfo);
    public List<UserInfo> selectList(UserInfo userInfo);
    public int insert(UserInfo userInfo);
    public int update(UserInfo userInfo);
    public int delete(UserInfo userInfo);
}