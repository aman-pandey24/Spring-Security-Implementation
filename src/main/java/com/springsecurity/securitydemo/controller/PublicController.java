package com.springsecurity.securitydemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String getMethodName(@AuthenticationPrincipal UserDetails userDetails) {
        return "Apis exposed for public, no authentication required here :" + "with thread name : " + Thread.currentThread().getName();
    }
}
