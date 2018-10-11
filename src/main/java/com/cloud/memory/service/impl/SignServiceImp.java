package com.cloud.memory.service.impl;

import com.cloud.memory.common.exceptions.ParamException;
import com.cloud.memory.common.util.IDUtil;
import com.cloud.memory.common.util.ValidatorRegUtil;
import com.cloud.memory.model.JsonResult;
import com.cloud.memory.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;

public class SignServiceImp implements SignService {

    @Autowired
    RedisServiceImpl redisService;

    @Autowired
    IDUtil idUtil;

    private static String PHONE_STR = "phone:";

    /**
     * 用户注册
     * @param phone
     * @param password
     * @param nickname
     * @return
     */
    @Override
    public JsonResult register(String phone, String password, String nickname) {
        JsonResult result;
        if (!ValidatorRegUtil.isMobile(phone)) {
            throw new ParamException("手机号码格式不正确");
        }
        if (!ValidatorRegUtil.isPassword(password)) {
            throw new ParamException("密码格式不正确");
        }
        if (!ValidatorRegUtil.isUsername(nickname)) {
            throw new ParamException("昵称格式不正确");
        }
        String verifyCode = redisService.get(PHONE_STR + phone);

        return null;
    }

    @Override
    public boolean nicknameUnique(String nickname) {
        return false;
    }


}
