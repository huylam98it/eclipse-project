package com.huylam98it.webuploadfile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.huylam98it.webuploadfile.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class Security_Config extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService myUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/register","/userupload").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user","/home").hasAnyRole("ADMIN","USER");
		
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/actionlogin")
			.usernameParameter("username")
			.passwordParameter("password")
			.failureUrl("/login?err=fail")
			.defaultSuccessUrl("/home");
		
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
		.and()
		.csrf().disable();
	}
}
