package com.sushe.dao;

import com.sushe.entity.School;

import java.util.List;

public interface SchoolMapper {
    int deleteByPrimaryKey(String id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
    List<School> selectAll();

}