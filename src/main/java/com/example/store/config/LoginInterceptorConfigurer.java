package com.example.store.config;

import com.example.store.interceptor.LoginInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor interceptor = new LoginInterceptor();

        List<String> patterns = new ArrayList<>();

        patterns.add("/bootstrap3/**");

        patterns.add("/css/**");

        patterns.add("/image/**");

        patterns.add("/js/**");

        patterns.add("/web/register.html");

        patterns.add("/web/login.html");

        patterns.add("/web/index.html");

        patterns.add("/web/product.html");

        patterns.add("/user/reg");

        patterns.add("/user/login");

        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);

    }
}
