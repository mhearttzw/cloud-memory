package com.cloud.memory.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 20:37
 * @description      redisService接口
 */
public interface RedisService {
    /**
     * redis设置值
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * redis获取值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * redis删除值
     * @param key key
     */
    void delete(String key);

    /**
     * redis删除值
     * @param key
     */
    void delete(Collection key);

    /**
     * @param timeout 基数
     * @description 设置过期时间
     */
    Boolean expire(String key, long timeout, TimeUnit timeUnit);

    /**
     * @param key
     * @param timeUnit 时间单位
     * @description 获取过期时间
     */
    Long getExpire(String key, TimeUnit timeUnit);

    Boolean flushDB();

    Long incr(String key);

    Long decr(String key);

    List<String> multiGet(Collection keys);

    void multiSet(Map<String, String> map);
}
