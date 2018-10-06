package com.cloud.memory.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 18:35
 * @description      Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * createRestApi() 方法指定扫描的包会生成文档,默认是显示所有接口,可以用@ApiIgnore注解标识该接口不显示
     */

    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloud.memory.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cloud Memory RESTful APIs")
                .description("云忆系统的API文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

}
