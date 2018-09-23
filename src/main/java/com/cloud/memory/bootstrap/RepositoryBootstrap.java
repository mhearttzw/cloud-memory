//package com.cloud.memory.bootstrap;
//
//import com.cloud.memory.repository.MyFirstLevelRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//@ComponentScan(basePackages = "com.cloud.memory.repository")
//public class RepositoryBootstrap {
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
//                .web(WebApplicationType.NONE)
//                .run();
//
//        MyFirstLevelRepository myFirstLevelRepository =
//                context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
//
//        System.out.println("Bean name: " + myFirstLevelRepository.toString());
//
//        // 关闭上下文
//        context.close();
//    }
//}
