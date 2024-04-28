package com.springsecurity.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping
    public String geString(){
        return "This api is exposed for admin only." + "No one else can access this";
    }
}
