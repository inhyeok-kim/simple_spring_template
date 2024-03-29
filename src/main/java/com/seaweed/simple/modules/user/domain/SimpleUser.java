package com.seaweed.simple.modules.user.domain;

import com.seaweed.simple.modules.user.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

public class SimpleUser {
    @Getter
    private long id;

    @Getter
    @Setter
    private String uid;

    @Getter
    @Setter
    private String name;

    public SimpleUser(UserEntity entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.name = entity.getName();
    }

    public SimpleUser(String uid, String name){
        this.uid = uid;
        this.name = name;
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setName(this.name);
        entity.setUid(this.uid);
        return entity;
    }

}
