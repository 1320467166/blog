package com.example.blog.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MySwagger {

    @Value("${swagger.enable}")
    private boolean swagger_is_enable;

    @Bean
    public Docket createRestApi() {
        // 文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                // 创建api的基本信息
                .apiInfo(apiInfo())
                // 选择哪些接口去暴露
                .select()
                // 扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.blog.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(swagger_is_enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("groundhog-web swagger文档")
                .description("swagger练习")
                .version("1.0")
                .build();
    }
}

