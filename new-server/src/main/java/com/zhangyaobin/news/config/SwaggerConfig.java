package com.zhangyaobin.news.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket createRestAppi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(controllerPath())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新闻")
                .description("请关注zhangyaobin.com")
                .termsOfServiceUrl("https://www.zhangyaobin.com")
                .version("1.0")
                .build();
    }

    private Predicate<String> controllerPath() {
        return or(
                regex("/news.*")
        );
    }

}
