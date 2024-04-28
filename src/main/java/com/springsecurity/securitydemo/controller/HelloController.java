package com.springsecurity.securitydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping("/world")
    public String getMethodName(@AuthenticationPrincipal UserDetails userDetails) {
        return "Hello world is running for user :" + userDetails.getUsername() + "with thread name : " + Thread.currentThread().getName();
    }
    
}
