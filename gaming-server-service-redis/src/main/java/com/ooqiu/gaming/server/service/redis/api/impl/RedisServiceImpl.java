package com.ooqiu.gaming.server.service.redis.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.service.redis.api.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>Title: RedisServiceImpl </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 12:54 2018/3/13
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_REDIS)
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds);
    }
}
