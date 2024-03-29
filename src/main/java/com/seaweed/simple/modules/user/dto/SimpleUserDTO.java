package com.seaweed.simple.modules.user.dto;

import com.seaweed.simple.modules.user.domain.SimpleUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleUserDTO {
    private long id;
    private String uid;
    private String name;

    public SimpleUserDTO(SimpleUser user){
        this.id = user.getId();
        this.uid = user.getUid();
        this.name = user.getName();
    }
}
