package com.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.airbnb.entities.User;
import com.dell.airbnb.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping(value = "/users")
    public List<User> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        repo.addUser(user);
        return user;
    }

    @PostMapping(value = "/users/{id}")
    public String updateUser(@PathVariable("id") int userInt, @RequestBody User user){
        repo.updateUser(userInt,user);

        return "Successfully Updated.";
    }
}