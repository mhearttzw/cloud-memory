package com.cloud.memory.common.enums;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 18:47
 * @description      自定义接口返回码
 */
public enum BusinessCode {
    SUCCESS("00000", "成功"),




    FAILED("10000", "系统出错"),
    FAIL("10001", "第三方接口调用失败");
    private String code;

    private String msg;

    BusinessCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
