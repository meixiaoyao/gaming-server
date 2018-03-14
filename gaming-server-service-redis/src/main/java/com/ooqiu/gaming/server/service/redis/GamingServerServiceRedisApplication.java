package com.ooqiu.gaming.server.service.redis;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: GamingServerServiceRedisApplication </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 13:02 2018/3/13
 */
@SpringBootApplication
public class GamingServerServiceRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceRedisApplication.class, args);
        Main.main(args);
    }
}
