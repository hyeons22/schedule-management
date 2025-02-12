package com.example.schedulemanagement.config;

import com.example.schedulemanagement.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 필터를 등록하는 코드
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean loginFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        // Filter 등록
        filterFilterRegistrationBean.setFilter(new LoginFilter());
        // Filter 순서 설정
        filterFilterRegistrationBean.setOrder(1);
        // 전체 URL에 Filter 적용
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }
}
