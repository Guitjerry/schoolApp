package com.sushe.service.impl;

import com.sushe.dao.hostelMapper;
import com.sushe.entity.Hostel;
import com.sushe.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/20.
 */
@Service("hostelService")
public class HostelServiceImpl implements HostelService {
    private hostelMapper hostelMapper;

    public hostelMapper getHostelMapper() {
        return hostelMapper;
    }
    @Autowired
    public void setHostelMapper(hostelMapper hostelMapper) {
        this.hostelMapper = hostelMapper;
    }

    @Override
    public Hostel selectHostelByBuildAndSchool(String name, String school_id) {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name);
        map.put("school_id",school_id);
        return hostelMapper.selectHostelByBuildAndSchool(map);
    }
}
