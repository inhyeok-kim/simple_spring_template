package com.seaweed.simple.modules.user.service;

import com.seaweed.simple.common.abstracts.service.DefaultService;
import com.seaweed.simple.modules.user.model.UserDTO;
import com.seaweed.simple.modules.user.model.UserEntity;
import com.seaweed.simple.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends DefaultService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO registUser(UserDTO user){
        UserEntity newUser = userRepository.save(user.toEntity());
        return new UserDTO(newUser);
    }

}
