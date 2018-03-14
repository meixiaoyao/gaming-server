package com.ooqiu.gaming.server.web.admin.config.thymeleaf;

import com.ooqiu.gaming.server.web.admin.config.thymeleaf.dialect.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: ThymeleafConfiguration </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 10:11 2018/3/9
 */
@Configuration
public class ThymeleafConfiguration {
    @Bean
    public ThSysDialect thSysDialect(){
        return new ThSysDialect();
    }
}
