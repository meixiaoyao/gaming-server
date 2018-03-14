package com.ooqiu.gaming.server.service.channel;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: GamingServerServiceChannelApplication </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 14:09 2018/3/9
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.server.service.channel.mapper")
public class GamingServerServiceChannelApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceChannelApplication.class, args);
        Main.main(args);
    }
}
