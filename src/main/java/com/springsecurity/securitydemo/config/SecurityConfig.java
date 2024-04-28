package com.springsecurity.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     UserDetails userDetails = User.builder().username("Aadesh").password("$2a$10$RF0UygdvCG5iAEJ6izSOQ.bZW4WI3/CREj0K8cj3EAUp8QyaTOnPi").roles("USER").build();
    //     UserDetails userDetails2 = User.builder().username("Pramod").password("$2a$10$YLBrvVOokxJ8Vg6uqpxDieIW.p32JUQu4F1XzZz.yE65TNnpNl9XG").roles("USER").build();

    //     return new InMemoryUserDetailsManager(userDetails, userDetails2);
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeRequests((auth)->{
            auth.requestMatchers("/admin/**").hasAuthority("ADMIN")
            .requestMatchers("/public/**").permitAll().anyRequest().authenticated();
        }).formLogin(Customizer.withDefaults()).build();
    }

}
