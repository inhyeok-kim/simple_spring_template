package com.seaweed.simple.modules.auth.service;

import com.seaweed.simple.common.abstracts.service.DefaultService;
import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.auth.entity.SimpleAuthEntity;
import com.seaweed.simple.modules.auth.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimpleAuthService extends DefaultService{
    @Autowired
    private AuthRepository authRepository;

    public SimpleAuth authenticate(String loginId, String password){
        SimpleAuthEntity entity = authRepository.findByLoginIdAndPassword(loginId,password);
        if(entity != null){
            return new SimpleAuth(entity);
        } else {
            return null;
        }
    }

    public long regist(SimpleAuth auth){
        return authRepository.save(auth.toEntity()).getId();
    }

}

