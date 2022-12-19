package com.yaxing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yx
 * @date 2022/12/8
 */
@Configuration
public class JWTInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns(
                        "/exams/**",
                        "/examQuestions/**",
                        "/isExam/**",
                        "/singleChooses/**",
                        "/subjects/**",
                        "/students/**",
                        "/token/**")
                .excludePathPatterns("/login", "/register");
    }
}
