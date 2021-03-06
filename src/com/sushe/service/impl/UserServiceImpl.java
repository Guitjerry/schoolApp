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

    @Override
    public User selectByAccount(String account) {
        User user=null;
        user=userDao.selectByAccount(account);
        return user;
    }
    public User selectByAccountAndPassword(String account,String password){
        User user=null;
        user=userDao.selectByAccountAndPassword(account,password);
        return user;
    }

    /**
     * 更新头像
     * @param user
     */
    public void updateSticker(User user){
        userDao.updateByPrimaryKeySelective(user);
    }
}
