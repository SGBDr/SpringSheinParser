package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicatiponSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicatiponSecurityConfig(PasswordEncoder p) {
		this.passwordEncoder = p;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/", "index", "/css/*").permitAll()
			.antMatchers("/springbot/**").hasRole(ApplicationUserRole.ADMIN.name())
			.antMatchers("/oo/**").hasAuthority(ApplicationUserPermission.STUDENT_WRITE.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	@Override
	@Bean
	protected  UserDetailsService userDetailsService() {
		UserDetails u = User.builder()
					.username("rode")
					.password(passwordEncoder.encode("rodrigue"))
					.roles(ApplicationUserRole.STUDENT.name())
					.authorities(ApplicationUserPermission.STUDENT_WRITE.name())
					.build();
		
		
		UserDetails s = User.builder()
				.username("maz")
				.password(passwordEncoder.encode("mazz"))
				.roles(ApplicationUserRole.ADMIN.name())
				.build();
		return new InMemoryUserDetailsManager(
					u,s
				);
	}
}
