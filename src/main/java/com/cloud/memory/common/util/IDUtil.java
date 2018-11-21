package com.cloud.memory.common.util;

import com.cloud.memory.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 20:30
 * @description      id生成工具类
 */
@Component
public class IDUtil {
    @Autowired
    private RedisService redisService;

    /**
     * @param prefix 前缀
     * @description 生成系统表id
     * @author zhangyanglei
     * @date 2017/9/4 15:27
     */
    public String genSysId(String prefix, String format) {
        long number = redisService.incr(prefix);
        String numberString = prefix + String.format(format, number);
        TimeUnit.SECONDS.toMillis(1L);
        return numberString;
    }
}
