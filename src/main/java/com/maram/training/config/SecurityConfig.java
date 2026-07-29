package com.maram.training.config; 

import org.springframework.context.annotation.*; 
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.provisioning.JdbcUserDetailsManager; 
import org.springframework.security.web.SecurityFilterChain; 
import javax.sql.DataSource;

@Configuration 
@EnableMethodSecurity 
public class SecurityConfig{
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();}
	@Bean
	UserDetailsService userDetailsService(DataSource d){
		return new JdbcUserDetailsManager(d);}
	@Bean
	SecurityFilterChain chain(HttpSecurity h)
			throws Exception{h.authorizeHttpRequests(a->a.requestMatchers("/css/**","/swagger-ui/**","/v3/api-docs/**","/actuator/health","/actuator/info")
					.permitAll().requestMatchers("/trainees/**")
					.hasAnyRole("ADMIN","TRAINER")
					.anyRequest().authenticated())
		.httpBasic(b->{}).formLogin(f->f.defaultSuccessUrl("/trainees",true)).logout(l->l.logoutSuccessUrl("/login")).csrf(c->c.ignoringRequestMatchers("/api/**"));
			return 
					h.build();}}
