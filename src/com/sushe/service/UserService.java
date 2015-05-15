package com.sushe.service;


import com.sushe.entity.User;

/**
 * Created by jiangbin on 15/4/13.
 */
public interface UserService {
    /**
     * 查询用户
     * @param id
     * @return
     */
    public User selectByPrimaryKey(String id);
    public int insertSimple(User user);
    public User selectByAccount(String account);
    public User selectByAccountAndPassword(String account,String password);
}
