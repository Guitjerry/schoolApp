package com.sushe.test;

import com.sushe.entity.Hostel;
import com.sushe.entity.HostelBuild;
import com.sushe.service.HostelService;
import com.sushe.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/20.
 */
public class Test {
    private HostelService hostelService;
    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-mvc.xml","classpath:spring-mybatis.xml"});
        hostelService= (HostelService) context.getBean("hostelService");
    }
    @org.junit.Test
      public void testSelectHostelByBuildAndSchool(){
        List<HostelBuild> hostels=hostelService.selectHostelByBuildAndSchool("东校区8栋", "1");
        System.out.print(hostels.get(0).getHostels().get(0).getName());
    }
    @org.junit.Test
    public void testUpdateByPrimaryKeySelective(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("id","1");
        map.put("user_id","d34c7346-1a59-44a5-9a6b-93d502b1a6dd");

        Map<String,String> user_map=new HashMap<String,String>();
        user_map.put("id","d34c7346-1a59-44a5-9a6b-93d502b1a6dd");
        user_map.put("name","测试姓名");
        System.out.println(hostelService.updateUserAndHostel(map,user_map));
    }
}
