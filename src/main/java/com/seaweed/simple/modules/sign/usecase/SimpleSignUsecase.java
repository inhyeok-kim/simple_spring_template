package com.seaweed.simple.modules.sign.usecase;

import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.auth.service.SimpleAuthService;
import com.seaweed.simple.modules.message.event.SimpleMessageEvent;
import com.seaweed.simple.modules.sign.domain.SimpleSign;
import com.seaweed.simple.modules.sign.dto.SimpleSignDTO;
import com.seaweed.simple.modules.user.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimpleSignUsecase {

    @Autowired
    private SimpleUserService simpleUserService;

    @Autowired
    private SimpleAuthService simpleAuthService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Transactional
    public void sign(SimpleSignDTO signDTO) throws Exception {
        SimpleSign sign = new SimpleSign(signDTO);
        long userId = simpleUserService.registUser(sign.getUser());
        SimpleAuth newAuth = sign.getAuth();
        newAuth.setUserId(userId);
        simpleAuthService.regist(newAuth);
        applicationEventPublisher.publishEvent(new SimpleMessageEvent("신규 사용자 가입 완료 | 아이디 : "+sign.getUser().getUid()+"이름 : "+sign.getUser().getName()));
    }
}
