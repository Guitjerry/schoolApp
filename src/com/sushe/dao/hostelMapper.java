package com.sushe.dao;

import com.sushe.entity.Hostel;
import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;

import java.util.List;
import java.util.Map;

public interface hostelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Hostel record);

    int insertSelective(Hostel record);

    Hostel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Hostel record);

    int updateByPrimaryKey(Hostel record);

    List<HostelBuild> selectHostelByBuildAndSchool(Map<String,String> map);
}