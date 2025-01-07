package com.graphql.controller;

import com.graphql.entity.User;
import com.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @MutationMapping
    public User createUser(@Argument String name,@Argument Integer marks){
        return userService.createUser(name,marks);
    }


    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public Optional<User> getUser(@Argument Integer id){
        return userService.getUser(id);
    }
}
