package com.sushe.service;

import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/20.
 */
public interface HostelService {
    /**
     *
     * @param name
     * @param school_id
     * @return
     */
   public List<HostelBuild> selectHostelByBuildAndSchool(String name,String school_id);

    /**
     * 更新宿舍信息
     * @param params
     */
    public int updateByPrimaryKeySelective(Map<String,String> params);
    /**
     * 更新宿舍与用户信息
     * @param params
     */
    public int updateUserAndHostel(Map<String,String> hostelMaps,Map<String,String> userMaps);
}
