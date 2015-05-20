package com.sushe.service;

import com.sushe.entity.School;

import java.util.List;

/**
 * Created by jiangbin on 15/4/23.
 */
public interface SchoolService {
    /**
     * 查询学校
     * @return
     */
    public List<School> selectAll();
    public School selectByName(String name);
}
