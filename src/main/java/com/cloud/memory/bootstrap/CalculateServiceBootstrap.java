//package com.cloud.memory.bootstrap;
//
//import com.cloud.memory.service.CalculateService;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//
//@SpringBootApplication(scanBasePackages = "com.cloud.memory.service")
//public class CalculateServiceBootstrap {
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
//                .profiles("pro")
//                .web(WebApplicationType.REACTIVE)
//                .run();
//
//        CalculateService calculateService =
//                context.getBean(CalculateService.class);
//
//        System.out.println("sum: " + calculateService.sum(1, 2, 3, 4, 5));
//
//        // 关闭上下文
//        context.close();
//    }
//}
