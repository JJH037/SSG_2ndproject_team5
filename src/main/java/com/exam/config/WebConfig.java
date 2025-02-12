package com.exam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /images/items/** 경로에 대해 로컬 파일 경로를 제공
        registry.addResourceHandler("/images/items/**")
                .addResourceLocations("file:/C:/upload/images/items/") // 파일을 C:/upload/images/items/로 제공
                .setCachePeriod(3600)  // 캐시 설정 (optional)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}

