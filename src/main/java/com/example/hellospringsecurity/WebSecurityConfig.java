package com.example.hellospringsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception{
      http
             .cors().and()
             .csrf().disable().authorizeRequests()
             .antMatchers("/users").access("hasRole('admin')")
             .anyRequest().authenticated()
             .and()
             .formLogin();
   }
}