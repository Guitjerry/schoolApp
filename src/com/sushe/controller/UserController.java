package com.sushe.controller;

import com.sushe.entity.Department;
import com.sushe.entity.School;
import com.sushe.entity.User;
import com.sushe.service.DepartMentService;
import com.sushe.service.SchoolService;
import com.sushe.service.UserService;
import com.sushe.util.JsonUtilTemp;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jiangbin on 15/4/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private SchoolService schoolService;
    @Resource
    private DepartMentService departMentService;

    @SuppressWarnings("finally")
    @RequestMapping(value = "/selectUserById",method = RequestMethod.GET)
    public void selectByPrimaryKey(String id,HttpServletResponse response){
        User user=new User();
        user= userService.selectByPrimaryKey(id);
        JsonUtilTemp.returnJson(user, response);
        //return user;
    }
    @SuppressWarnings("finally")
    @RequestMapping(value = "/insertSimple")
    @ResponseBody
    public void insertSimple(HttpServletRequest request,HttpServletResponse response, User user){
        try{
            user.setId(UUID.randomUUID().toString());
            int userId= userService.insertSimple(user);
            JsonUtilTemp.returnSucessJson(response,"会员注册成功");
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response, "会员注册失败");
        }

    }

    @SuppressWarnings("finally")
    @RequestMapping(value = "/selectSchool")
    public void selectSchool(HttpServletResponse response){

        List<School> moreSchool=new ArrayList<School>();
        try{
            moreSchool=schoolService.selectAll();
            JsonUtilTemp.returnJson(moreSchool,response);
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response, "插入失败");
        }

    }
    @SuppressWarnings("finally")
    @RequestMapping(value = "/selectSchoolDepartment")
    public void selectSchoolDepartment(HttpServletResponse response,HttpServletRequest request){
        List<Department> departments=new ArrayList<Department>();
        try{
            departments=departMentService.selectDepartmentBySchool("1");
            JsonUtilTemp.returnJson(departments,response);
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response, "插入失败");
        }
    }

}
