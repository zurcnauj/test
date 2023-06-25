package com.test.testSpringboot.config.sercurity;


import com.test.testSpringboot.config.sercurity.filters.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityFilter securityFilter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.securityFilter)
        .addPathPatterns("/**")
        .excludePathPatterns("/token");
    }
}
