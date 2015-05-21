package com.sushe.service;

import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;

import java.util.List;

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
}
