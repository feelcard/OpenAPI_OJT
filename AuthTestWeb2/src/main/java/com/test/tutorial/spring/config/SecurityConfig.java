package com.test.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and().authorizeRequests()
		.antMatchers("/users/{userId}").access("@authenticationCheckHandler.checkUserId(authentication,#userId)")
		.antMatchers("/admin/db/**").access("hasRole('ADMIN_MASTER') or hasRole('ADMIN') and hasRole('DBA')")
		.antMatchers("/register/**").hasRole("ANONYMOUS")
		.and().formLogin()
		.loginPage("/login").usernameParameter("email").passwordParameter("password")
		//.successHandler(successHandler()).failureHandler(failureHandler())
	    .permitAll();
		
		/* httpBasic() : http 통신으로 인증받겠다 (ssl로도 가능)
		 * authorizeRequests() : 접근권한이 허용된 요청만 처리하겠다는 의미
		 * antMatchers() : String 경로 아래의 요청은 인증되어야 함을 명시한다.(/ == web)?
		 * access() :  주어진 SpEL 표현식의 평가 결과가 true이면 접근을 허용
		 *  spEL= 스프링 표현언어
		 */
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
