package com.home;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.home.security.customauth.CustomAuthenticationProvider;
import com.home.security.customauth.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	@Autowired 
	private DataSource dataSource;
	
//	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	//	auth.jdbcAuthentication().dataSource(dataSource);
		
		auth.authenticationProvider(customAuthenticationProvider());
		
		/*
		UserBuilder user = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
			.withUser(user.username("john").password("john123").roles("USER"))
			.withUser(user.username("mary").password("mary123").roles("USER", "MANAGER"))
			.withUser(user.username("admin").password("admin123").roles("USER", "ADMIN"));
		*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/manager/**").hasRole("MANAGER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/access").hasRole("USER")
			.anyRequest().denyAll()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/process").permitAll()
			.and().logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	/*
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.httpFirewall(null);
	}
	*/
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		return new CustomAuthenticationProvider();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(customUserDetailsService());
		
		return daoAuthenticationProvider;
	}
	
	@Bean
	public RoleHierarchyImpl roleHierarchyImpl() {
		
		RoleHierarchyImpl hierarchyImpl = new RoleHierarchyImpl();
		hierarchyImpl.setHierarchy("ROLE_MANAGER > ROLE_ADMIN > ROLE_USER");
		return hierarchyImpl;
	}
	
	@Bean
	public RoleHierarchyVoter RoleHierarchyVoter() {
		return new RoleHierarchyVoter(roleHierarchyImpl());
	}
}
