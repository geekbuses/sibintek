package ru.sibintek.test.jsonsstorage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
public class SwaggerConfig {
    @Value("${address}")
    private String address;
    @Value("${server.port}")
    private String port;

    public static final class TagNames {
        public static final String SEARCH = "Поиск";
        public static final String STORAGE = "Хранилище";
    }

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .tags(
                        new Tag(TagNames.SEARCH,"Сервис поиска"),
                        new Tag(TagNames.STORAGE,"Сервис для работы с хранилищем")
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.sibintek.test.jsonsstorage.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(true);
    }

    private ApiInfo apiInfo() {
        String url = address.concat(port);
        return new ApiInfoBuilder()
                .title("STORAGE REST API Specification")
                .description("Описание REST API тест проекта STORAGE")
                .license(url)
                .licenseUrl(url)
                .build();
    }
}
