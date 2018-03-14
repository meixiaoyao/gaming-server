package com.ooqiu.gaming.server.service.search;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: GamingServerServiceSearch </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 13:21 2018/3/13
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.server.service.search.mapper")
public class GamingServerServiceSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceSearchApplication.class, args);
        Main.main(args);
    }
}
