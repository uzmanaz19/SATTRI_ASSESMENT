package com.student.management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .requestMatchers("/api/department/**").hasRole("ROLE_PRINCIPAL")
                .requestMatchers("/api/staff/**").hasAnyRole("ROLE_STAFF","ROLE_HOD")
                .requestMatchers("/api/student/**").hasRole("ROLE_STAFF")
                .requestMatchers("/api/student-profile/**").hasAnyRole("ROLE_STAFF","ROLE_STUDENT")
                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
