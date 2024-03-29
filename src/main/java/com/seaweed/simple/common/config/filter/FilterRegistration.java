package com.seaweed.simple.common.config.filter;

import com.seaweed.simple.modules.auth.domain.Role;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setExcludeUrl(new String[]{"/auth","/h2-console","/api"});
        registrationBean.setFilter(filter);
        registrationBean.setName("Authentication filter");
        registrationBean.addUrlPatterns("*");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> userAuthorizationFilter(){
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        AuthorizationFilter authorizationFilter = new AuthorizationFilter(Role.USER);
        authorizationFilter.setExcludeUrl(new String[]{"/auth","/h2-console","/adm","/api"});
        registrationBean.setFilter(authorizationFilter);
        registrationBean.setName("user Authorization filter");
        registrationBean.addUrlPatterns("*");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> adminAuthorizationFilter(){
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        AuthorizationFilter authorizationFilter = new AuthorizationFilter(Role.USER);
        authorizationFilter.setExcludeUrl(new String[]{"/auth","/h2-console","/api"});
        registrationBean.setFilter(authorizationFilter);
        registrationBean.setName("admin Authorization filter");
        registrationBean.addUrlPatterns("/adm/*");
        return registrationBean;
    }
}
