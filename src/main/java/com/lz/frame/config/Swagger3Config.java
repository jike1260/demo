package com.lz.frame.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName Swagger3Config
 * @Description //TODO  swagger3配置
 * @Author lz
 * @Date 14:43 2020/11/25
 */
@Configuration
public class Swagger3Config {

    @Value("${swagger3.title}")
    private String title;

    @Value("${swagger3.description}")
    private String description;

    @Value("${swagger3.version}")
    private String version;

    @Value("${swagger3.contact.name}")
    private String name;

    @Value("${swagger3.contact.url}")
    private String url;

    @Value("${swagger3.contact.email}")
    private String email;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(name, url, email))
                .version(version)
                .build();
    }
}
