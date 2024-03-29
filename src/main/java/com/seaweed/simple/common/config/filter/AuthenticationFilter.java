package com.seaweed.simple.common.config.filter;

import com.seaweed.simple.common.abstracts.filter.SimpleFilter;
import com.seaweed.simple.common.component.http.session.SessionAuthenticationContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Slf4j
public class AuthenticationFilter extends SimpleFilter {

    @Override
    public void filter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if(!SessionAuthenticationContext.isAuthenticated(session)){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"code\" : -100, \"message\" : \"unAuthenticated\"}");
        }

    }
}
