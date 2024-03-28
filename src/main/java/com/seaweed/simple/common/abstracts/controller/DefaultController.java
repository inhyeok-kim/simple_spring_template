package com.seaweed.simple.common.abstracts.controller;

import com.seaweed.simple.common.response.ResponseBuilder;
import com.seaweed.simple.modules.auth.service.SimpleAuthService;
import com.seaweed.simple.modules.user.model.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class DefaultController {

    @Autowired
    public ResponseBuilder responseBuilder;

    public UserDTO getLoginUser(){
        ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
        UserDTO loginUser = (UserDTO) httpSession.getAttribute(SimpleAuthService.SESSION_LOGIN_NAME);

        return loginUser;
    }


}
