package br.com.eleicaoonline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/**", "/swagger-resources/**", "/swagger-ui.html", "/auth/**", "/login/oauth2/**","/logout").permitAll()
		.anyRequest().authenticated().and()
		.oauth2Login() 
		.defaultSuccessUrl("/api/autenticacao", true)
		.and()
        .logout()        
        .invalidateHttpSession(true)
        .clearAuthentication(true);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}

}