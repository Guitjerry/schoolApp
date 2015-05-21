package com.sushe.dao;

import com.sushe.entity.Hostel;
import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface hostelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Hostel record);

    int insertSelective(Hostel record);

    Hostel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Hostel record);

    int updateByPrimaryKey(Hostel record);

    List<HostelBuild> selectHostelByBuildAndSchool(@Param("name") String name,@Param("school_id") String school_id);

    /**
     * 更新宿舍表关联用户
     * @param id
     */
    int updateByPrimaryKeySelective(Map<String,String> params);
}