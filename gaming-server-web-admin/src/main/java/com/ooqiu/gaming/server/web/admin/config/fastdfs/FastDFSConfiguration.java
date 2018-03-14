package com.ooqiu.gaming.server.web.admin.config.fastdfs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java 配置方式定义 StorageFactory 的 Bean 使其可以被依赖注入
 * <p>Title: FastDFSConfiguration </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 10:34 2018/3/8
 */
@Configuration
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory(){
        return new StorageFactory();
    }
}
