package com.sushe.service.impl;

import com.sushe.dao.DepartmentMapper;
import com.sushe.entity.Department;
import com.sushe.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiangbin on 15/4/23.
 */
@Service("departmentService")
public class DepartMentServiceImpl implements DepartMentService{
    private DepartmentMapper departmentMapper;

    public DepartmentMapper getDepartmentMapper() {
        return departmentMapper;
    }
    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> selectDepartmentBySchool(String id) {
       return departmentMapper.selectSchoolDepartment(id);

    }
}
