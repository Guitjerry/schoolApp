package com.sushe.controller;

import com.sun.deploy.net.HttpResponse;
import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;
import com.sushe.service.HostelService;
import com.sushe.util.JsonUtilTemp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<HostelBuild> hostelBuilds=null;
            hostelBuilds=hostelService.selectHostelByBuildAndSchool(name, school_id);
            if(hostelBuilds!=null){
               // JsonUtilTemp.returnSucessJson(response,"查询宿舍成功");
                JsonUtilTemp.returnObjAndSuccessJson(hostelBuilds, response);
            }else{
                JsonUtilTemp.returnFailJson(response,"查询宿舍失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response,"查询宿舍接口出错");
        }
    }
    @RequestMapping("/updateHostelUser")
    public void updateUserAndHostel(@RequestParam("id") String id,@RequestParam("user_id") String user_id,@RequestParam("name") String name,HttpServletResponse response){
        Map<String,String> map=new HashMap<String,String>();
        map.put("id",id);
        map.put("user_id",user_id);

        Map<String,String> user_map=new HashMap<String,String>();
        user_map.put("name",name);
        user_map.put("id",user_id);

        try{
            //需要把楼号的其他宿舍设置为空再设置
            int result=hostelService.updateUserAndHostel(map,user_map);
            if(result==1){
                JsonUtilTemp.returnSucessJson(response,"更新宿舍用户成功");
            }else{
                JsonUtilTemp.returnFailJson(response, "更新宿舍用户成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response,"获取接口出错");
        }
    }


}
