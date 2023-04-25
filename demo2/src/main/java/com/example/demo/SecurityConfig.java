package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// MemberServiceImpl에 있는것을 시큐리티가 가져다가 씀
	@Bean	// <bean id="" class=""> 
	public PasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
			.antMatchers("/home","/").permitAll() // home은 아무나 접근가능
			.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
			.anyRequest().authenticated()) // 나머지 모든 요청은 로그인해야지만 가능
		.formLogin(login -> login.defaultSuccessUrl("/home")
			//.loginPage("/login")
			//.usernameParameter("id")
			//.defaultSuccessUrl("/home") // 로그인 성공시
			.loginPage("/login")
			.usernameParameter("userid")
			.permitAll())
			//.and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home") // 로그아웃 성공시
			.permitAll();
		//	.and()
		//.csrf().disable();
	return http.build();
	
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
	
	// static 아래에 있는것들은 다 넣어주면됨
	// 정적 컨텐츠들은 다 넣어주면됨
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**");
	}
	
	
	
}
