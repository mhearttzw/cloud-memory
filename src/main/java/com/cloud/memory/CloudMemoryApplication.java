package com.cloud.memory;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author          echelon
 * @email           2954632969@qq.com
 * @created_time    2018/9/14 17:19
 * @description     启动类
 */

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration
@EnableFeignClients
//@ServletComponentScan(basePackages = "com.cloud.memory.web.servlet")
public class CloudMemoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMemoryApplication.class, args);
    }
}
