package com.seaweed.simple.modules.auth.service;

import com.seaweed.simple.common.abstracts.service.DefaultService;
import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.auth.entity.SimpleAuthEntity;
import com.seaweed.simple.modules.auth.model.AuthRegistDTO;
import com.seaweed.simple.modules.auth.repository.AuthRepository;
import com.seaweed.simple.modules.crypto.RSACrypto;
import com.seaweed.simple.modules.crypto.SHACrypto;
import com.seaweed.simple.modules.user.model.UserDTO;
import com.seaweed.simple.modules.user.model.UserEntity;
import com.seaweed.simple.modules.user.repository.UserRepository;
import com.seaweed.simple.modules.user.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Optional;

@Service
@Slf4j
public class SimpleAuthService extends DefaultService{
    public static String SESSION_LOGIN_NAME = "loginUser";
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private String PUBLIC_KEY;
    private String PRIVATE_KEY;
    @PostConstruct
    public void init(){
        HashMap<String, String> keypairs = RSACrypto.createKeypairAsString();
        this.PUBLIC_KEY = keypairs.get("publicKey");
        this.PRIVATE_KEY = keypairs.get("privateKey");
        log.info("Auth :: RSA Crypto Key Created");
        log.info("Auth :: Public Key = " + PUBLIC_KEY);
        log.info("Auth :: Private Key = " + PRIVATE_KEY);
    }

    public SimpleAuth authenticate(String loginId, String password){
        SimpleAuthEntity entity = authRepository.findByLoginIdAndPassword(loginId,password);
        if(entity != null){
            return new SimpleAuth(entity);
        } else {
            return null;
        }
    }

}