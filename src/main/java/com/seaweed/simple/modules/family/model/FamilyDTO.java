package com.seaweed.simple.modules.family.model;

import com.seaweed.simple.modules.user.model.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class FamilyDTO {
    private long id;
    private String name;
    private List<UserDTO> userList;

    public FamilyDTO(FamilyEntity entity, boolean includeUser){
        this.id = entity.getId();
        this.name = entity.getName();
        if(includeUser){
            this.userList = entity.getUserList().stream().map(userEntity-> new UserDTO(userEntity,false)).toList();
        }
    }

    public FamilyEntity toEntity(){
        FamilyEntity entity = new FamilyEntity();
        entity.setName(this.name);
        if(userList != null){
            entity.setUserList(this.userList.stream().map(UserDTO::toEntity).toList());
        }
        return entity;
    }
}
