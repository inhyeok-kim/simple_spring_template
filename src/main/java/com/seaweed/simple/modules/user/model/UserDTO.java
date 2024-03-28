package com.seaweed.simple.modules.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String uid;
    private String name;
    public UserDTO(UserEntity entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.name = entity.getName();
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setName(this.name);
        entity.setUid(this.uid);
        return entity;
    }

}
