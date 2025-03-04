package com.ty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ty.service.MyUserDetailService;

import jakarta.websocket.Session;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// lambda function3
		// disable csrf
		http.csrf(customizer -> customizer.disable());
		// Enable Login Restrictions
		http.authorizeHttpRequests(
				request -> request.requestMatchers("register", "login").permitAll().anyRequest().authenticated());
		// Enable Login Page
		http.formLogin(Customizer.withDefaults());
		// To Enable Login in Postman
		http.httpBasic(Customizer.withDefaults());
		// To make stateless (Everytime create new sessionId)
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		// Create in-memory users
//		UserDetails user1 = User.withDefaultPasswordEncoder().username("madhu").password("madhu123").roles("USER")
//				.build();
//
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("anu").password("anu123").roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user1, user2);
//	}

	@Autowired
	private MyUserDetailService detailService;

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		provider.setUserDetailsService(detailService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configration) throws Exception {
		return configration.getAuthenticationManager();
	}
}