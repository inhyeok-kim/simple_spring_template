package com.seaweed.simple.modules.auth.usecase;

import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.auth.service.SimpleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthUsecase {

    @Autowired
    private SimpleAuthService authService;

    public SimpleAuth login(String loginId, String password){
        return authService.authenticate(loginId,password);
    }


}
