package com.sushe.controller;

import com.sushe.util.JsonUtilTemp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangbin on 15/5/16.
 */
@Controller

public class FileController {
    /**
     * 上传到临时文件
     * @param file
     * @param response
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ModelAndView handleFormUpload(@RequestParam("name") String name,@RequestParam("file") MultipartFile file,HttpServletResponse response){
        ModelAndView mav=new ModelAndView();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String fileName=file.getOriginalFilename();
                String size= String.valueOf(file.getSize());
                Map<String,String> map=new HashMap<String, String>();
                map.put("filename",fileName);
                map.put("size",size);
                mav.setViewName("success");
                //JsonUtilTemp.returnJson(map,response);
            } catch (IOException e) {
                e.printStackTrace();
                mav.setViewName("fail");

            }

        } else {
            mav.setViewName("fail");
            //JsonUtilTemp.returnFailJson(response,"上传文件不能为空");
        }
        mav.addObject("name",name);
        return mav;

    }


}
