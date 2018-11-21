//package com.cloud.memory.bootstrap;
//
//import com.cloud.memory.condition.ConditionalOnSystemProperty;
//import com.cloud.memory.service.CalculateService;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//
///**
// * @author          echelon
// * @created_time    2018/9/16 20:58
// * @description     系统属性条件判断引导类
// */
//@ConditionalOnSystemProperty(name = "user.name", value = "小马哥")
//public class OnSystemPropertyConditionBootstrap {
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = new SpringApplicationBuilder(OnSystemPropertyConditionBootstrap.class)
//                .profiles("pro")
//                .web(WebApplicationType.NONE)
//                .run();
//
//
//        // 关闭上下文
//        context.close();
//    }
//}
