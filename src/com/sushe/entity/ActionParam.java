package com.sushe.entity;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/5/14.
 * 记录请求参数的bean
 */
public class ActionParam {
    private String url;//请求地址
    private HashMap<String,String> urlParams;//请求参数
    private String actionType;//请求类型(web端,手机端)
    private String module;//请求模块(用户,商品等)

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getUrlParams() {
        return urlParams;
    }

    public void setUrlParams(HashMap<String, String> urlParams) {
        this.urlParams = urlParams;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
