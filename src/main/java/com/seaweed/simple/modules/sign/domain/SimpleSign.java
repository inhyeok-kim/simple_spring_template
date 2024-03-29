package com.seaweed.simple.modules.sign.domain;


import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.sign.dto.SimpleSignDTO;
import com.seaweed.simple.modules.user.domain.SimpleUser;
import lombok.Getter;

public class SimpleSign {

    @Getter
    private SimpleAuth auth;

    @Getter
    private SimpleUser user;

    public SimpleSign(SimpleSignDTO dto) throws Exception {
        this.auth = new SimpleAuth(dto.getLoginId(), dto.getPassword());
        this.user = new SimpleUser(dto.getLoginId(),dto.getUserName());
    }


}
