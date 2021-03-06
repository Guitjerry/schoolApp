package com.sushe.controller;

import com.sushe.service.FileUploadUtil;
import com.sushe.util.JsonUtilTemp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangbin on 15/5/16.
 */
@Controller

public class FileController {
    @Resource
    private FileUploadUtil fileUploadUtil;
    /**
     * 上传到临时文件
     * @param file
     * @param response
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public void handleFormUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav=new ModelAndView();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String fileName=file.getOriginalFilename();
                String size= String.valueOf(file.getSize());
                Map<String,String> map=new HashMap<String, String>();

                String uploadPath=request.getContextPath()+"upload/";
                //复制文件到临时目录
                fileUploadUtil.SaveFileFromInputStream(file.getInputStream(),uploadPath,fileName);
                map.put("filename",fileName);
                map.put("size",size);
                map.put("upload",uploadPath);
                JsonUtilTemp.returnJson(map,response);




            } catch (Exception e) {
                e.printStackTrace();
                JsonUtilTemp.returnFailJson(response,"上传文件异常");

            }

        } else {
            mav.setViewName("fail");
            JsonUtilTemp.returnFailJson(response,"上传文件不能为空");
        }

    }


}
