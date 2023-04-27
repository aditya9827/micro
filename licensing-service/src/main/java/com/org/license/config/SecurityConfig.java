package com.org.license.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests((auth) -> {
				try {
					auth
														 .requestMatchers(HttpMethod.GET, "/v1/organization/*")
														 .hasAuthority("SCOPE_read")
														 .requestMatchers(HttpMethod.POST, "/v1/organization/*")
														 .hasAuthority("SCOPE_add-org")
														 .anyRequest().permitAll()
														 .and()
														 .oauth2ResourceServer(oauth-> oauth.jwt());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
					
		
		return http.build();
	}

}
