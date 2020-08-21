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
		
		/* httpBasic() : http ������� �����ްڴ� (ssl�ε� ����)
		 * authorizeRequests() : ���ٱ����� ���� ��û�� ó���ϰڴٴ� �ǹ�
		 * antMatchers() : String ��� �Ʒ��� ��û�� �����Ǿ�� ���� ����Ѵ�.(/ == web)?
		 * access() :  �־��� SpEL ǥ������ �� ����� true�̸� ������ ���
		 *  spEL= ������ ǥ�����
		 */
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
