package com.foodie.config;

import javafx.util.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    //htttp://localhost:8088/swagger-ui.html
    //htttp://localhost:8088/doc.html
    //配置swagger2 核心配置 docket
    @Bean
    public Docket createRestApi(){
        return  new Docket(DocumentationType.SWAGGER_2)         //指定Api类型为swagger2
                .apiInfo(apiInfo())                              //用于定义API文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.foodie.controller"))      //指定Controller包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("干饭人 电商平台接口API")              // 文档标题
                .contact( new Contact("BigOrange",
                        "https://www.imooc.com",
                        "bigorange.weicheng@gmail.com" // 联系人信息
                        ))
                .description("专门为干饭人提供的API文档")      // 详细信息
                .version("1.0.1")                              // 版本号
                .termsOfServiceUrl("www.baidu.com")            // 网站地址
                .build();
    }
}
