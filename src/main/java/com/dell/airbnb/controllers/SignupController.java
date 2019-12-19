package com.dell.airbnb.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.dell.airbnb.entities.User;
import com.dell.airbnb.repositories.UserRepository;
import com.dell.airbnb.security.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SignupController {
    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/signup")
    public Map<String, String> signup(@RequestBody User user) {
        repository.save(user);
        String token = JwtUtils.generateJwt(user);

        Map<String, String> body = new HashMap<>();
        body.put("token", token);

        return body;
    }

}