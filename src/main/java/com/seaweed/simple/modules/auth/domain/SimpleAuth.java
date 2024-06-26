package com.seaweed.simple.modules.auth.domain;


import com.seaweed.simple.modules.auth.entity.SimpleAuthEntity;
import com.seaweed.simple.common.util.crypto.SHACryptoUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.security.NoSuchAlgorithmException;

public class SimpleAuth {
    @Getter
    private long id;

    @Getter
    private String loginId;
    @Getter
    private String password;

    @Getter
    @Setter
    private long userId;

    @Getter
    private final String type = "simple";
    private static final String PASSWORD_SALT = "simple_password";


    public SimpleAuth(String loginId, String password) throws Exception {
        if(!StringUtils.hasText(password) || !StringUtils.hasText(loginId)) throw new Exception();
        this.loginId = loginId;
        this.password = encryptPassword(password);
    }

    public SimpleAuth(SimpleAuthEntity entity){
        this.id = entity.getId();
        this.loginId = entity.getLoginId();
        this.password = entity.getPassword();
    }

    public SimpleAuthEntity toEntity(){
        SimpleAuthEntity entity = new SimpleAuthEntity();
        entity.setLoginId(loginId);
        entity.setPassword(password);
        return entity;
    }

    private static String encryptPassword(String password) throws NoSuchAlgorithmException {
        return SHACryptoUtil.encrypt(password,PASSWORD_SALT);
    }

}
