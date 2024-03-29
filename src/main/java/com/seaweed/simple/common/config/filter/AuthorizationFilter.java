package com.seaweed.simple.common.config.filter;

import com.seaweed.simple.common.abstracts.filter.SimpleFilter;
import com.seaweed.simple.modules.auth.domain.Role;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class AuthorizationFilter extends SimpleFilter {

    private Role role;

    public AuthorizationFilter(Role role){
        this.role = role;
    }

    @Override
    public void filter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();


    }
}
