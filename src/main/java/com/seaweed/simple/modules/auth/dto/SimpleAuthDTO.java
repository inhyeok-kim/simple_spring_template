package com.seaweed.simple.modules.auth.dto;

import lombok.Data;

@Data
public class SimpleAuthDTO {
    private long id;
    private String loginId;
    private String password;
    private long userId;

}
