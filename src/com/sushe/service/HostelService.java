package com.sushe.service;

import com.sushe.entity.Hostel;

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
   public Hostel selectHostelByBuildAndSchool(String name,String school_id);
}
