package com.example.hrplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/").setViewName("main_page.html");
        registry.addViewController("/registration").setViewName("registration.html");
        registry.addViewController("/account_info").setViewName("account_info.html");
    }

}
