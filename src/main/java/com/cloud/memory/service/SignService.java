package com.cloud.memory.service;

import com.cloud.memory.model.JsonResult;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 20:01
 * @description      注册登录服务层
 */
public interface SignService {

    /**
     * 用户注册
     * @param phone
     * @param password
     * @param nickname
     * @return
     */
    JsonResult register(String phone, String password, String nickname);
}
