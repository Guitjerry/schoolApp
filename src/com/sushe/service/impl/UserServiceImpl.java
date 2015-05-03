package com.sushe.service.impl;

import com.sushe.dao.UserDao;
import com.sushe.entity.User;
import com.sushe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangbin on 15/4/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSimple(User user) {
        return userDao.insertSimple(user);
    }
}
