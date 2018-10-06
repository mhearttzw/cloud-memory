package com.cloud.memory.service.impl;

import com.cloud.memory.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 22:20
 * @description      rediService实现类
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * redis设置值
     * @param key   key
     * @param value value
     */
    @Override
    public void set(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * redis获取值
     * @param key key
     * @return String
     */
    @Override
    public String get(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * redis删除值
     * @param key key
     */
    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

    /**
     * @param key
     * @param timeout  基数
     * @param timeUnit 单位
     * @description 设置过期时间
     */
    @Override
    public Boolean expire(String key, long timeout, TimeUnit timeUnit) {
        Boolean flag = redisTemplate.expire(key, timeout, timeUnit);
        return flag;
    }

    @Override
    public Long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, TimeUnit.MINUTES);
    }

    @Override
    public Boolean flushDB() {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return true;
            }
        });
    }

    @Override
    public Long incr(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Long increment = valueOperations.increment(key, 1L);
        return increment;
    }

    @Override
    public Long decr(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.increment(key, -1L);
    }

    @Override
    public List<String> multiGet(Collection keys) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.multiGet(keys);
    }

    @Override
    public void multiSet(Map map) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.multiSet(map);
    }
}
