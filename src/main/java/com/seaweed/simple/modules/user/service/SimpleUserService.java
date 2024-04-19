package com.seaweed.simple.modules.user.service;

import com.seaweed.simple.common.abstracts.service.DefaultService;
import com.seaweed.simple.modules.user.domain.SimpleUser;
import com.seaweed.simple.modules.user.entity.UserEntity;
import com.seaweed.simple.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleUserService extends DefaultService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationContext applicationContext;

    public SimpleUser getUserDTOById(long id){
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            return new SimpleUser(userOpt.get());
        }
        return null;
    }

    public long registUser(SimpleUser user){
        UserEntity newUser = userRepository.save(user.toEntity());

        return newUser.getId();
    }

}
