package com.seaweed.simple.modules.regist.service;

import com.seaweed.simple.common.abstracts.service.DefaultService;
import com.seaweed.simple.modules.auth.entity.SimpleAuthEntity;
import com.seaweed.simple.modules.auth.model.AuthRegistDTO;
import com.seaweed.simple.modules.auth.repository.AuthRepository;
import com.seaweed.simple.modules.user.model.UserDTO;
import com.seaweed.simple.modules.user.model.UserEntity;
import com.seaweed.simple.modules.user.repository.UserRepository;
import com.seaweed.simple.modules.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class SimpleRegistService extends DefaultService{
    public static String SESSION_LOGIN_NAME = "loginUser";
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public UserDTO registUser(AuthRegistDTO registUser){
        UserDTO signUser = new UserDTO();
        signUser.setName(registUser.getName());
        signUser.setUid(registUser.getLoginId());
        UserDTO newUser = userService.registUser(signUser);

        Optional<UserEntity> user = userRepository.findById(newUser.getId());
        if(user.isPresent()){
            SimpleAuthEntity auth = new SimpleAuthEntity();
            auth.setPassword(registUser.getPassword());
            auth.setLoginId(registUser.getLoginId());
            authRepository.save(auth);
            return new UserDTO(user.get());
        }

        return null;

    }
}
