package com.atguigu.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回处理类
 */
public class Msg {
    private Integer code;
    private String msg;
    private Map<String,Object> extend = new HashMap<>();

    public Msg() {
    }

    public Msg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理失败");
        return result;
    }
    public Msg add(String key,Object obj){
        this.extend.put(key,obj);
        return this;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
