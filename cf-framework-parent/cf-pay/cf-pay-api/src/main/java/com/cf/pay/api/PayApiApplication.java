package com.cf.pay.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 请在此填写描述
 *
 * @ClassName SmsApiApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/11/21/021 23:36
 * @Version 1.0
 **/
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.cf.pay.api"})
@ComponentScan(basePackages = {"com.cf.framework"})   //扫描common包,因为我们需要在Common中统一捕获异常和其它处理
@EnableSwagger2
public class PayApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApiApplication.class, args);
    }
}
