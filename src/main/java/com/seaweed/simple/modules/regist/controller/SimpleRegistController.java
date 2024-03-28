package com.seaweed.simple.modules.regist.controller;

import com.seaweed.simple.common.abstracts.controller.DefaultController;
import com.seaweed.simple.modules.auth.model.AuthRegistDTO;
import com.seaweed.simple.modules.regist.service.SimpleRegistService;
import com.seaweed.simple.modules.user.model.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/sign")
public class SimpleRegistController extends DefaultController {

    @Autowired
    private SimpleRegistService simpleRegistService;

    @PostMapping("")
    public ResponseEntity signOn(HttpServletRequest request, HttpServletResponse response,
                                 @RequestBody Map body
    ) throws NoSuchAlgorithmException {
        String loginId = (String) body.get("loginId");
        String name = (String) body.get("name");
        String password = (String) body.get("password");
        AuthRegistDTO authRegistDTO = new AuthRegistDTO(loginId, name, password);

        UserDTO newUser = simpleRegistService.registUser(authRegistDTO);
        if(newUser == null){
            return responseBuilder.responseFail();
        }

        return responseBuilder.response();
    }

}
