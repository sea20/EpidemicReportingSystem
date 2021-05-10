package com.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Configuration

@EnableWebMvc

@EnableSwagger2

@ComponentScan(basePackages = "com.controller")//扫描control所在的package请修改为你control所在package

public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket createRestApi() {

        String environment = "test";

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        ApiInfo apiInfo = new ApiInfoBuilder()

                .title("[主站项目接口文档]")

                .description("测试环境接口测试")

                .version("1.0")

                .build();

        docket.apiInfo(apiInfo);

        //设置只生成被Api这个注解注解过的Ctrl类中有ApiOperation注解的api接口的文档

        if(environment.equals("master")) {

            //生产环境下接口文档关闭不展示

            docket.select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))

                    .paths(PathSelectors.none())

                    .build();

        }else{

            //测试环境接口展示

            docket.select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                    .paths(PathSelectors.any())

                    .build();
            //System.out.println(PathSelectors.any());

        }
        return docket;

    }



}