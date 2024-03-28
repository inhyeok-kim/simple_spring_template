package com.seaweed.simple.modules.auth.controller;

import com.seaweed.simple.common.abstracts.controller.DefaultController;
import com.seaweed.simple.common.component.SessionAuthenticationContext;
import com.seaweed.simple.modules.auth.domain.SimpleAuth;
import com.seaweed.simple.modules.auth.model.AuthRegistDTO;
import com.seaweed.simple.modules.auth.service.SimpleAuthService;
import com.seaweed.simple.modules.user.model.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Slf4j
public class SimpleAuthController extends DefaultController {

    @Autowired
    private SimpleAuthService simpleAuthService;

    @PostMapping("")
    public ResponseEntity login(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody Map body
    ) {
        String loginId = (String) body.get("loginId");
        String password = (String) body.get("password");
        if(!StringUtils.hasText((loginId)) || !StringUtils.hasText(password)){
            return responseBuilder.responseBadError();
        }

        SimpleAuth simpleAuth = simpleAuthService.authenticate(loginId, password);

        if(simpleAuth == null){
            return responseBuilder.responseFail("no matched id and password");
        } else {
            SessionAuthenticationContext.authenticate(request.getSession(),simpleAuth.getUserUId(),simpleAuth.getType());
        }

        return responseBuilder.response();
    }


    @GetMapping("")
    public ResponseEntity check(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        UserDTO loginUser = getLoginUser();
        if(loginUser == null) {
            return responseBuilder.responseUnAuthenticated();
        }

        return responseBuilder.response(loginUser);
    }

}
