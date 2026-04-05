package com.UKaKi.ukaki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        return http
            .authorizeHttpRequests(auth->auth
                .requestMatchers("/","/**").permitAll()
            )
            .formLogin(login->login
                .loginPage("/login")
            )
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails user1=User
                            .withUsername("kirti")
                            .password(passwordEncoder.encode("kirtika"))
                            .roles("USER")
                            .build();
        UserDetails user2=User
                            .withUsername("karti")
                            .password(passwordEncoder.encode("kartikey"))
                            .roles("USER")
                            .build();
        UserDetails user3=User 
                            .withUsername("uda")
                            .password(passwordEncoder.encode("uday"))
                            .roles("USER")
                            .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

}
