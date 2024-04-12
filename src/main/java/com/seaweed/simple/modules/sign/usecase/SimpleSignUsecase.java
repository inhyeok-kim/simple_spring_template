package com.seaweed.simple.modules.sign.usecase;

import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.auth.service.SimpleAuthService;
import com.seaweed.simple.modules.sign.domain.SimpleSign;
import com.seaweed.simple.modules.sign.dto.SimpleSignDTO;
import com.seaweed.simple.modules.user.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleSignUsecase {

    @Autowired
    private SimpleUserService simpleUserService;

    @Autowired
    private SimpleAuthService simpleAuthService;


    public void sign(SimpleSignDTO signDTO) throws Exception {
        SimpleSign sign = new SimpleSign(signDTO);
        long userId = simpleUserService.registUser(sign.getUser());
        SimpleAuth newAuth = sign.getAuth();
        newAuth.setUserId(userId);
        simpleAuthService.regist(newAuth);

    }
}
