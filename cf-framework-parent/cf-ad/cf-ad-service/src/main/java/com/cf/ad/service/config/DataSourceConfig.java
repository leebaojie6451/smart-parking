package com.cf.ad.service.config;

import org.springframework.context.annotation.Configuration;

/**
 * 如果需要shardingsphere分库分表功能时，需要把下面的配置类打开
 */
@Configuration
public class DataSourceConfig {

//    @ConfigurationProperties(prefix="spring.shardingsphere.datasource")
//    @Bean
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }

}
