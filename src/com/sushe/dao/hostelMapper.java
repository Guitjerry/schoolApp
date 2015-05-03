package com.sushe.dao;

import com.sushe.entity.hostel;

public interface hostelMapper {
    int deleteByPrimaryKey(String id);

    int insert(hostel record);

    int insertSelective(hostel record);

    hostel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(hostel record);

    int updateByPrimaryKey(hostel record);
}