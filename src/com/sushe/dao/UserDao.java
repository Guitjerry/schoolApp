package com.sushe.dao;


import com.sushe.entity.User;

public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);
    int insertSimple(User simpleUser);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer selectByAccount(String account);
}