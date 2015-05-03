package com.sushe.util;

/**
 * Created by jiangbin on 15/4/14.
 */
public class Result {
    public String status;
    public String msg;

    public Result(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
