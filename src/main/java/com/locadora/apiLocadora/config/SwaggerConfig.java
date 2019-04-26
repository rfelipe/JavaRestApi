package com.locadora.apiLocadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apilocadora() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.locadora.apiLocadora"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Produto API REST Filme",
                "Api REST Locadora de filme.",
                "1.0",
                "Terms of service",
                new Contact("Felipe s Rodrigues", "https://github.com/rfelipe",
                        "rodrigues.souza.felipe@gmail.com"),
                "Apache Lincense Version 2.0",
                "http://www.apache.org/licenen.html", new ArrayList<VendorExtension>());
        return  apiInfo;
    }


}
