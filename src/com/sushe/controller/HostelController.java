package com.sushe.controller;

import com.sushe.entity.Hostel;
import com.sushe.service.HostelService;
import com.sushe.util.JsonUtilTemp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/5/20.
 */
@Controller
@RequestMapping("/hostel")
public class HostelController {
    @Resource
    private HostelService hostelService;
    @RequestMapping("/selectHostelByBuildAndSchool")
    public void selectHostelByBuildAndSchool(@RequestParam("name") String name,@RequestParam("school_id") String school_id,HttpServletResponse response){
        try{
            Hostel hostel=null;
           hostel=hostelService.selectHostelByBuildAndSchool(name, school_id);
            if(hostel!=null){
                JsonUtilTemp.returnSucessJson(response,"查询宿舍成功");
                JsonUtilTemp.returnJson(hostel,response);
            }else{
                JsonUtilTemp.returnFailJson(response,"查询宿舍失败");
            }
        }catch (Exception e){
            JsonUtilTemp.returnFailJson(response,"查询宿舍接口出错");
        }
    }
}
