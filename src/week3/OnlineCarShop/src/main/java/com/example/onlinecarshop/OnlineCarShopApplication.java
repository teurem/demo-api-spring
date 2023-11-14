package com.example.onlinecarshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
public class OnlineCarShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCarShopApplication.class, args);
	}

//	@EnableWebSecurity
//	public static class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

//		@Override
//		public void configure(HttpSecurity http) throws Exception {
//			http
//					.httpBasic(withDefaults())
//					.authorizeRequests(authorizeRequests ->
//							authorizeRequests
//									.anyRequest().authenticated()
//					);
//		}
	}

