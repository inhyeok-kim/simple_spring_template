package com.seaweed.simple.modules.user.usecase;

import com.seaweed.simple.common.abstracts.service.DefaultService;
import com.seaweed.simple.modules.user.dto.SimpleUserDTO;
import com.seaweed.simple.modules.user.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleUserUsecase extends DefaultService {

    @Autowired
    private SimpleUserService simpleUserService;

    public SimpleUserDTO findUserById(long id){
        return new SimpleUserDTO(simpleUserService.getUserDTOById(id));
    }
}
