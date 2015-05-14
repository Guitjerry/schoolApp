package com.sushe.filter;

import com.sushe.entity.ActionParam;
import com.sushe.util.JsonUtilTemp;
import com.sushe.util.PropertiesUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Administrator on 2015/5/14.
 * 过滤器,主要用来记录各个请求的接口
 */
@WebFilter(filterName = "ActionFilter")
public class ActionFilter implements Filter {
    private FilterConfig filterConfig;
    public void destroy() {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if("only_read".equals(filterConfig.getInitParameter("debug_type"))){
            HttpServletRequest request= (HttpServletRequest) req;
            HttpServletResponse response= (HttpServletResponse) resp;
            ActionParam actionParam=new ActionParam();
            //获取请求的所有参数
            HashMap map=new HashMap<String,String>();
            Enumeration paramNames= request.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName= (String) paramNames.nextElement();
                String[] paramValues=request.getParameterValues(paramName);
                if(paramValues.length==1){
                    String paramValue=paramValues[0];
                    if(paramValue.length()!=0){
                        map.put(paramName,paramValue);
                    }
                }

            }
            actionParam.setUrl(request.getContextPath()+request.getRequestURI());
            Properties properties=PropertiesUtil.getProperties("module.properties");
            String url=request.getRequestURI();
            actionParam.setModule(properties.getProperty(url.substring(0, url.indexOf("/"))));
            actionParam.setUrlParams(map);
            JsonUtilTemp.returnJson(actionParam,response);


        }else if("only_insert".equals(filterConfig.getInitParameter("debug_type"))){

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;
    }

}
