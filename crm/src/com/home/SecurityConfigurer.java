package com.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		
		// authorized pages
		.antMatchers("/register", "/process-register").hasAnyRole("ANONYMOUS", "MANAGER")
		.antMatchers("/customer/list").hasRole("USER")
		.antMatchers("/customer/update", "/customer/delete").hasRole("MANAGER")
		.antMatchers("/", "/resources/**").permitAll()
		.anyRequest().denyAll()
		
		// login
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/customer/list").loginProcessingUrl("/process-login").permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/denied")
		
		.and().addFilterBefore(new HiddenHttpMethodFilter(), ChannelProcessingFilter.class);
	}
	
	@Bean
	public RoleHierarchyImpl roleHierarchyImpl() {
		
		RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
		roleHierarchyImpl.setHierarchy("ROLE_MANAGER > ROLE_USER");
		
		return roleHierarchyImpl;
	}
	
	@Bean
	public RoleHierarchyVoter roleHierarchyVoter() {
		return new RoleHierarchyVoter(roleHierarchyImpl());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = 
				PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}
}
