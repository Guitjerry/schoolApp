package com.sushe.dao;

import com.sushe.entity.HostelBuild;

public interface HostelBuildMapper {
    int deleteByPrimaryKey(String id);

    int insert(HostelBuild record);

    int insertSelective(HostelBuild record);

    HostelBuild selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HostelBuild record);

    int updateByPrimaryKey(HostelBuild record);
}