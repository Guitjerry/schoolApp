package com.sushe.util;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangbin on 15/4/14.
 */
public class JsonUtilTemp {
    public static void returnJson(Object obj,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter writer=response.getWriter();
            writer.write(JSON.toJSONString(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void returnObjAndSuccessJson(Object obj,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter writer=response.getWriter();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("status","success");
            map.put("entity",obj);
            writer.write(JSON.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 查询成功返回相应对象
     * @param response
     * @param msg
     * @throws Exception
     */
    public static void returnSucessJson(HttpServletResponse response,String msg)throws  Exception{
        response.setContentType("text/html;charset=UTF-8");
        Result result=new Result("success",msg);
        PrintWriter writer=response.getWriter();
        writer.write(JSON.toJSONString(result));
    }

    /**
     * 查询失败返回相应对象
     * @param response
     * @param msg
     * @throws Exception
     */
    public static void returnFailJson(HttpServletResponse response,String msg){
        response.setContentType("text/html;charset=UTF-8");
        Result result=new Result("fail",msg);
        PrintWriter writer= null;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 接口发生异常
     * @param response
     * @param msg
     * @throws Exception
     */
    public static void returnExceptionJson(HttpServletResponse response,String msg){
        response.setContentType("text/html;charset=UTF-8");
        Result result=new Result("exception",msg);
        PrintWriter writer= null;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

