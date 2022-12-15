package com.trollmarket.config;

import com.trollmarket.config.authentication.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfig {

    @Autowired
    private CustomAuthenticationProvider getAuth;

    @Order(2)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/account/**").permitAll()
                .antMatchers("/profile/**").hasAnyAuthority("Buyer","Seller")
                .antMatchers("/merchandise/**").hasAuthority("Seller")
                .antMatchers("/shop/**","/mycart/**").hasAuthority("Buyer")
                .antMatchers("/shipment/**","/admin/**","/history/**").hasAuthority("Administrator")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/account/loginForm")
                .loginProcessingUrl("/authenticating")// get this for free from Spring Security
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/account/accesDenied");
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(getAuth)
                .build();
    }

}
