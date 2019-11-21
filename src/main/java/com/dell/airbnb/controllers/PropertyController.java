package com.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.airbnb.entities.Property;
import com.dell.airbnb.repositories.PropertyRepository;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository repo;

    @GetMapping(value = "/propertys")
    public List<Property> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/propertys")
    public Property create(@RequestBody Property property) {
        repo.addProperty(property);
        return property;
    }

    @PostMapping(value = "/propertys/{id}")
    public String updateProperty(@PathVariable("id") int propertyInt, @RequestBody Property property){
        repo.updateProperty(propertyInt,property);

        return "Successfully Updated.";
    }
}