package com.seaweed.simple.modules.auth.domain;


import com.seaweed.simple.modules.auth.entity.SimpleAuthEntity;
import com.seaweed.simple.modules.crypto.SHACrypto;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.security.NoSuchAlgorithmException;

public class SimpleAuth {
    @Getter
    private String loginId;
    private String password;

    @Getter
    private String UserUId;

    @Getter
    private final String type = "simple";
    private final String PASSWORD_SALT = "simple_password";


    public SimpleAuth(String loginId, String password) throws Exception {
        if(!StringUtils.hasText(password) || !StringUtils.hasText(loginId)) throw new Exception();
        this.loginId = loginId;
        this.password = encryptPassword(password);
    }

    public SimpleAuth(SimpleAuthEntity entity){
        this.loginId = entity.getLoginId();
        this.password = entity.getPassword();
    }

    public SimpleAuthEntity toEntity(){
        SimpleAuthEntity entity = new SimpleAuthEntity();
        entity.setLoginId(loginId);
        entity.setPassword(password);
        return entity;
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        return SHACrypto.encrypt(password,PASSWORD_SALT);
    }

}
