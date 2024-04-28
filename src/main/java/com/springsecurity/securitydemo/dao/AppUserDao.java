package com.springsecurity.securitydemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.securitydemo.entity.AppUser;

@Repository
public interface AppUserDao extends JpaRepository<AppUser,Long>{
    
    AppUser findByEmail(String email);
}
