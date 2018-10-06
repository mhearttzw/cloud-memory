package com.cloud.memory.common.exceptions;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 19:06
 * @description      参数错误异常
 */
public class ParamException extends RuntimeException {
    public ParamException(String message) {
        super(message);
    }
}
