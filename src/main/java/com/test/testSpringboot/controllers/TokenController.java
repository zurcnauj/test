package com.test.testSpringboot.controllers;

import com.test.testSpringboot.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping
    public String get(){
        return jwtUtils.generateToken();
    }
}
