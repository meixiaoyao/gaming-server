package com.ooqiu.gaming.server.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>Title: ${CLASS_NAME} </p>
 * <p>Description: </p>
 *
 * @author Eve
 * @version 1.0.0
 * @date 上午 9:21 2018/3/1 0001
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GamingServerWebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerWebAdminApplication.class, args);
    }
}
