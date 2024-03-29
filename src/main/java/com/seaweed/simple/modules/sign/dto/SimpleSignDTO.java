package com.seaweed.simple.modules.sign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleSignDTO {

    private String loginId;
    private String password;
    private String userName;
}
