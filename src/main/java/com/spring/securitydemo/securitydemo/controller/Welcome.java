package com.spring.securitydemo.securitydemo.controller;

import com.spring.securitydemo.securitydemo.entity.UserInfo;
import com.spring.securitydemo.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Welcome {
    @Autowired
    UserService service;

    @PostMapping("/add-user")
    public String addNewUser(@RequestBody UserInfo userInfo){
        Long l = service.addUser(userInfo);
        return  l.toString();
    }


    @GetMapping("/")
    public String getFirst() {
        return "welcome";
    }

    @GetMapping("/product")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<String> listAllproduct() {
        return List.of("Apple", "BMW", "Real Estates");
    }

    @GetMapping("/msg")
    @PreAuthorize("hasAuthority('USER')")
    public String welcomeUser() {
        return "Welcome user Hello world";
    }
}