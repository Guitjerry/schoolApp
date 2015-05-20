package com.sushe.controller;

import com.sushe.entity.School;
import com.sushe.service.SchoolService;
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
@RequestMapping("/school")
public class SchoolController {
    @Resource
    private SchoolService schoolService;

    /**
     * 根据名称查找学校
     * @param name
     */
    @RequestMapping(value="/selectSchoolByName")
    public void selectSchoolByName(@RequestParam("name") String name,HttpServletResponse re){
        try{
            School school=schoolService.selectByName(name);
            JsonUtilTemp.returnSucessJson(re,"查询学校成功");
            JsonUtilTemp.returnJson(school,re);
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(re,"查询学校失败");
        }
    }
}
