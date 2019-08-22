package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigtn extends WebSecurityConfigurerAdapter{

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests().anyRequest().authenticated()
            .and().fotmLogin();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     http
                    .auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password)).authorities("USER");
        }
}
