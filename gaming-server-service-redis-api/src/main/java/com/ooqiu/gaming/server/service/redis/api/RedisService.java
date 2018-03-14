package com.ooqiu.gaming.server.service.redis.api;

/**
 * <p>Title: RedisService </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 12:49 2018/3/13
 */
public interface RedisService {
    public Object get(String key);

    public void set(String key, Object value);

    /**
     * 带过期时间的
     * @param key
     * @param value
     * @param seconds 过期时间
     */
    public void set(String key, Object value, long seconds);
}
