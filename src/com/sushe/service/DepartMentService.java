package com.sushe.service;

import com.sushe.entity.Department;

import java.util.List;

/**
 * Created by jiangbin on 15/4/23.
 */
public interface DepartMentService {
    /**
     * 根据学校查找所有系别
     * @param id
     * @return
     */
    public List<Department> selectDepartmentBySchool(String id);
}
