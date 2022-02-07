package com.example.blog.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 设置key 以及过期时间
     * @param key
     * @param object
     * @param expireTime
     */
    public void set(String key, Object object, Long expireTime) {
        redisTemplate.opsForValue().set(key,object,expireTime, TimeUnit.SECONDS);
    }

    /**
     * 获取key值
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置过期时间
     * @param key
     */
    public void expire(String key) {
        redisTemplate.expire(key,-1,TimeUnit.SECONDS);
    }
}
