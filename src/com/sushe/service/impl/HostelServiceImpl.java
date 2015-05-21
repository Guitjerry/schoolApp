package com.sushe.service.impl;

import com.sushe.dao.UserDao;
import com.sushe.dao.hostelMapper;
import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;
import com.sushe.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/20.
 */
@Service("hostelService")
public class HostelServiceImpl implements HostelService {
    private hostelMapper hostelMapper;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public hostelMapper getHostelMapper() {
        return hostelMapper;
    }
    @Autowired
    public void setHostelMapper(hostelMapper hostelMapper) {
        this.hostelMapper = hostelMapper;
    }

    @Override
    public List<HostelBuild> selectHostelByBuildAndSchool(String name, String school_id) {
        return hostelMapper.selectHostelByBuildAndSchool(name,school_id);
    }
    @Override
    public int updateByPrimaryKeySelective(Map<String,String> params){
        return hostelMapper.updateByPrimaryKeySelective(params);
    }

    @Override
    public int updateUserAndHostel(Map<String, String> hostelMaps,Map<String, String> userMaps) {
       int re= userDao.updateByPrimaryKeySelective(userMaps);
        if(re==1){
            return hostelMapper.updateByPrimaryKeySelective(hostelMaps);
        }else{
            return 0;
        }

    }


}
