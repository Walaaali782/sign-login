package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeRequests()
	        .requestMatchers("/signup", "/login").permitAll()  // Make "/signup" and "/login" accessible to all
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginProcessingUrl("/login") // تأكد من أن Spring Security يستخدم "/login" كمسار لمعالجة تسجيل الدخول
	            .permitAll()
	        .and()
	        .httpBasic(); // Enable basic authentication
	    return http.build();
	}

}