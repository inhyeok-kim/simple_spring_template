package com.seaweed.simple.modules.user.model;

import com.seaweed.simple.common.abstracts.entity.DefaultEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "HM_USER")
@Data
@NoArgsConstructor
@ToString
public class UserEntity extends DefaultEntity {
    private String name;
    private String uid;

    public UserEntity(String name, String uid){
        this.name = name;
        this.uid = uid;
    }

}
