package com.seaweed.simple.modules.auth.entity;

import com.seaweed.simple.common.abstracts.entity.DefaultEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SIMPLE_AUTH")
@NoArgsConstructor
@Data
public class SimpleAuthEntity extends DefaultEntity {

    private String loginId;
    private String password;
    private String userId;

}
