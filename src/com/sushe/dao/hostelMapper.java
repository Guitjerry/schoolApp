package com.sushe.dao;

import com.sushe.entity.Hostel;
import com.sushe.entity.Hostel;

public interface hostelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Hostel record);

    int insertSelective(Hostel record);

    Hostel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Hostel record);

    int updateByPrimaryKey(Hostel record);

    Hostel selectHostelByBuildAndSchool(String name,String school_id);
}