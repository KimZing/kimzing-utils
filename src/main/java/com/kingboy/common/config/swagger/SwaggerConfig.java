package com.kingboy.common.config.swagger;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/11/20 下午7:19
 * @desc Swagger配置.
 */
@Data
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "king.swagger")
@ConditionalOnProperty(name = "king.swagger.enabled", havingValue = "true")
@ConditionalOnClass(value = Swagger2Controller.class)
public class SwaggerConfig {

    private String basePackage = "com.kingboy.controller";

    private String title = "他很懒什么都没有留下";

    private String description = "他很懒什么都没有留下";

    private String version = "V1.0";


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }
}
