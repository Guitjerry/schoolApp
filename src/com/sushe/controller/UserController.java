package com.sushe.controller;

import com.sushe.entity.Department;
import com.sushe.entity.School;
import com.sushe.entity.User;
import com.sushe.service.DepartMentService;
import com.sushe.service.FileUploadUtil;
import com.sushe.service.SchoolService;
import com.sushe.service.UserService;
import com.sushe.util.ImageCut;
import com.sushe.util.JsonUtilTemp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

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
    @Resource
    private FileUploadUtil fileUploadUtil;
    private String uploadPath; // 上传路径
    private String downloadPath; // 下载(显示)路径
    private String uploadPathTemp;// 上传临时路径
    private String downloadPathTemp; // 下载(显示)临时路径路径

    public String getUploadPathTemp() {
        return uploadPathTemp;
    }

    @Value(value = "#{public.annexUserTempPath}")
    public void setUploadPathTemp(String uploadPathTemp) {
        this.uploadPathTemp = uploadPathTemp;
    }

    public String getDownloadPathTemp() {
        return downloadPathTemp;
    }

    @Value(value = "#{public.annexUserTempUrl}")
    public void setDownloadPathTemp(String downloadPathTemp) {
        this.downloadPathTemp = downloadPathTemp;
    }

    @Value(value = "#{public.annexUserPath}")
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Value(value = "#{public.annexUserUrl}")
    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }
    //private static Logger logger= LoggerFactory.getLogger(UserController.class);

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
            request.getSession().setAttribute("user",user);
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
    @SuppressWarnings("finally")
    @RequestMapping(value = "/regiestUser")
    public void regiestUser(HttpServletResponse response,HttpServletRequest request){
        String account=request.getParameter("account");
        User validateUser=null;
        User loginUser=null;
        try{
                loginUser=userService.selectByAccount(account);
                if(loginUser!=null){
                    //logger.debug("......................用户已存在");
                    JsonUtilTemp.returnFailJson(response,"用户已存在!");
                }else{
                    //logger.debug("......................用户没有被注册");
                    JsonUtilTemp.returnSucessJson(response, "注册用户成功!");
                }
            } catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response, "查询数据失败,接口异常");
        }


    }

    @SuppressWarnings("finally")
    @RequestMapping(value = "/login")
    public void selectByAccount(HttpServletResponse response,HttpServletRequest request,User user){
        User loginUser=null;
        User validateUser=null;
        try{
            validateUser=userService.selectByAccount(user.getAccount());
            if(validateUser==null){
                JsonUtilTemp.returnFailJson(response,"账号不存在");
            }else{
                loginUser=userService.selectByAccountAndPassword(user.getAccount(), user.getPassword());
                if(loginUser!=null){
                    request.getSession().setAttribute("user",loginUser);
                    request.getSession().setAttribute("downloadPath",downloadPath);
                    JsonUtilTemp.returnSucessJson(response, "登录系统成功");

                    //return new ModelAndView("module/main/index","user",user);

                }else{
                    //logger.debug("......................用户没有被注册");
                    JsonUtilTemp.returnFailJson(response, ",用户名或密码错误,登录系统失败!");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnExceptionJson(response, "查询数据失败,接口异常");
        }
    }

    /**
     * 上传头像图片
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/uploadSticker")
    public void uploadSticker(@RequestParam("file") MultipartFile file,HttpServletResponse response){
        if(file.isEmpty()){
            JsonUtilTemp.returnFailJson(response,"上传文件不能为空");
        }else{
            try {
                byte[] bytes = file.getBytes();
                String fileName=file.getOriginalFilename();
                String size= String.valueOf(file.getSize());
                Map<String,String> map=new HashMap<String, String>();
                //复制文件到临时目录
                String newName=fileUploadUtil.SaveFileFromInputStream(file.getInputStream(),uploadPath,fileName);
                map.put("filename",newName);
                map.put("size",size);
                map.put("upload",downloadPath);
                JsonUtilTemp.returnJson(map,response);
            } catch (Exception e) {
                e.printStackTrace();
                JsonUtilTemp.returnFailJson(response,"上传文件异常");
            }

        }
    }

    /**
     * 上传裁剪头像
     * @param id
     * @param sticker
     * @param account
     * @param x1
     * @param y1
     * @param cw
     * @param ch
     * @param request
     * @param response
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/updateUserSticker")
    public void updateUserSticker(@RequestParam("id") String id,
                                  @RequestParam("sticker") String sticker,
                                  @RequestParam("account") String account,
                                  @RequestParam("x1") String x1,
                                  @RequestParam("y1") String y1,
                                  @RequestParam("cw") String cw,
                                  @RequestParam("ch") String ch,
                                  HttpServletRequest request,
                                  HttpServletResponse response){
            // 将文件复制到指定目录下
        String oldPath =uploadPath+"/"+sticker;
        String newFilePath=uploadPath+"/"+account;
        // 创建文件目录
        File savedir140 = new File(newFilePath);
        int bytesum = 0;
        int byteread = 0;
        File oldfile = new File(oldPath);
        // 如果目录不存在就创建
        if (!savedir140.exists()) {
            savedir140.mkdirs();
        }
        try {
            if (!x1.equals("") && !("0").equals(x1)) {
                int intx1 = Integer.parseInt(x1);
                int inty1 = Integer.parseInt(y1);
                int intcw = Integer.parseInt(cw);
                int intch = Integer.parseInt(ch);
                String dirPath = oldPath;
                String toPath = newFilePath + "/" + sticker;
                ImageCut.cut(intx1, inty1, intcw, intch, dirPath, toPath);
            } else {
                InputStream inStream = null; // 读入原文件
                inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newFilePath + "/" + sticker);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response,"文件操作异常");
        }

        //保存头像到用户
        User user=new User();
        user.setId(id);
        user.setSticker(sticker);


        try{
            //更新session的user
            HashMap<String,Object> obj=new HashMap<>();
            User tmpUser=(User)request.getSession().getAttribute("user");
            tmpUser.setSticker(sticker);
            obj.put("user",tmpUser);
            obj.put("status","success");
            JsonUtilTemp.returnJson(obj,response);
            userService.updateSticker(user);
        }catch (Exception e){
            e.printStackTrace();
            JsonUtilTemp.returnFailJson(response,"更新头像接口出错");
        }


    }




}
