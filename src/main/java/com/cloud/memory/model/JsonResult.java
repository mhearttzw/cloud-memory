package com.cloud.memory.model;

import com.alibaba.fastjson.JSON;
import com.cloud.memory.common.enums.BusinessCode;
import lombok.Data;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 18:42
 * @description      接口统一返回model
 */
@Data
public class JsonResult<T> {
    private String msg;
    private String code;
    private T data;

    public JsonResult() {
    }

    public JsonResult(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public JsonResult(String code, String msg, T data){
        this.msg = msg;this.code = code;this.data = data;
    }

    public JsonResult(String msg, T data){
        this.msg = msg;this.data = data;
    }

    public JsonResult(BusinessCode businessCode){
        this.code = businessCode.getCode();
        this.msg = businessCode.getMsg();
    }

    public JsonResult(BusinessCode businessCode, String reason){
        this.code = businessCode.getCode();
        this.msg = businessCode.getMsg() + reason;
    }

    public JsonResult(BusinessCode businessCode, T data){
        this.code = businessCode.getCode();
        this.msg = businessCode.getMsg();
        this.data = data;
    }

    public JsonResult set(BusinessCode businessCode, T data){
        this.code = businessCode.getCode();
        this.msg = businessCode.getMsg();
        this.data = data;
        return this;
    }

    public JsonResult set(BusinessCode businessCode){
        this.code = businessCode.getCode();
        this.msg = businessCode.getMsg();
        return this;
    }


    public T getData() {
        return data;
    }

    public JsonResult setData(T data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public JsonResult setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String toJson(){
        return JSON.toJSONString(this);
    }

    public static JsonResult buildResponse(String msg, String code){
        return new JsonResult(code,msg,null);
    }

    public static JsonResult buildResponse(String msg, Object data){
        return new JsonResult(msg,data);
    }




}
