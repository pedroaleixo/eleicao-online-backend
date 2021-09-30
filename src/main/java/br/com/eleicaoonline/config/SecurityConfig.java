package br.com.eleicaoonline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		 .csrf().disable()
		.httpBasic().disable()
		.authorizeRequests()
		.antMatchers("/api/**", 
				"/swagger-resources/**",  
				"/swagger-ui.html")		
		.permitAll()
        .anyRequest().permitAll();
	}
}