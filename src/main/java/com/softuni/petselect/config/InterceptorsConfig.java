package com.softuni.petselect.config;

import com.softuni.petselect.web.IPBlackListInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

    private final IPBlackListInterceptor ipBlackListInterceptor;

    public InterceptorsConfig(IPBlackListInterceptor ipBlackListInterceptor) {
        this.ipBlackListInterceptor = ipBlackListInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipBlackListInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
