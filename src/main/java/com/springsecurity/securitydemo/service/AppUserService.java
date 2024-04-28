package com.springsecurity.securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.securitydemo.dao.AppUserDao;
import com.springsecurity.securitydemo.entity.AppUser;

@Service
public class AppUserService implements UserDetailsService{

    @Autowired
    AppUserDao appUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserDao.findByEmail(username);
        if(appUser ==null){
            throw new UsernameNotFoundException("user does not exist.");
        }
        return appUser;
    }
    
}
