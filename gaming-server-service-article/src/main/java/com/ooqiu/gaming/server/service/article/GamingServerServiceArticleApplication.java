package com.ooqiu.gaming.server.service.article;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: GamingServerServiceArticleApplication </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 14:34 2018/3/9
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.server.service.article.mapper")
public class GamingServerServiceArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceArticleApplication.class, args);
        Main.main(args);
    }
}
