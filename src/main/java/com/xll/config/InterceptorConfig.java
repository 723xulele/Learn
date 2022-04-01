package com.xll.config;

import com.xll.Interceptor.JWTInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author xulele
 * @Date: 2022/03/29/0:38
 * @Description:
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {

    /** 除了用户登录的接口 其他接口都需要验证token */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/student/**")
                .excludePathPatterns("/student/login");
    }
}
