package com.softuni.petselect.config;

import com.softuni.petselect.service.impl.MaintenanceInterceptorImpl;
import com.softuni.petselect.web.IPBlackListInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class
 InterceptorsConfig implements WebMvcConfigurer {

    private final IPBlackListInterceptor ipBlackListInterceptor;
    private final LocaleChangeInterceptor localeChangeInterceptor;
    private final MaintenanceInterceptorImpl maintenanceInterceptor;


    public InterceptorsConfig(IPBlackListInterceptor ipBlackListInterceptor, LocaleChangeInterceptor localeChangeInterceptor, MaintenanceInterceptorImpl maintenanceInterceptor) {
        this.ipBlackListInterceptor = ipBlackListInterceptor;
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.maintenanceInterceptor = maintenanceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipBlackListInterceptor);
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(maintenanceInterceptor);

        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
