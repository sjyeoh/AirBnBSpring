package com.dell.airbnb.controllers;

import com.dell.airbnb.entities.User;
import com.dell.airbnb.repositories.UserRepository;
import com.dell.airbnb.security.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
public class TestController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping(value = "/restricted")
    public String restricted() {
        return "{\"message\": \"This is restricted\"}";
    }

    @GetMapping(value = "/public")
    public String testPublic() {
        return "{\"message\": \"This is public\"}";
    }

    @GetMapping(value = "/currentUser")
    public User currentUser() {
        return userDetailsService.getCurrentUser();
    }

    @GetMapping(value = "/testing")
    public String testing() {
        return "{\"message\": \"Testing is restricted\"}";
    }

    @GetMapping(value = "/testing2")
    public String testing2() {
        return "{\"message\": \"Testing2 is public\"}";
    }
}