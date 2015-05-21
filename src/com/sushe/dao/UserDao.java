package com.sushe.dao;


import com.sushe.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);
    int insertSimple(User simpleUser);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccount(@Param(value = "account") String account);
    
    User selectByAccountAndPassword(@Param(value = "account") String account,@Param(value="password") String password);

    int updateByPrimaryKeySelective(Map<String,String> map);
}