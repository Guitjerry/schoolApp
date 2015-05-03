package com.sushe.service.impl;

import com.sushe.dao.SchoolMapper;
import com.sushe.entity.School;
import com.sushe.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiangbin on 15/4/23.
 */
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    private SchoolMapper schoolMapper;

    public SchoolMapper getSchoolMapper() {
        return schoolMapper;
    }
    @Autowired
    public void setSchoolMapper(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    @Override
    public List<School> selectAll() {

        return schoolMapper.selectAll();
    }
}
