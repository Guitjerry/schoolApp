package com.sushe.test;

import com.sushe.entity.Hostel;
import com.sushe.service.HostelService;
import com.sushe.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

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
       Hostel hostel=hostelService.selectHostelByBuildAndSchool("东校区8栋", "1");
        System.out.printf(hostel.toString());
    }
}
