package com.seaweed.simple.modules.auth.controller;

import com.seaweed.simple.common.abstracts.controller.DefaultController;
import com.seaweed.simple.modules.auth.model.AuthRegistDTO;
import com.seaweed.simple.modules.user.model.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/sso")
@Slf4j
public class SSOAuthController extends DefaultController {


}
