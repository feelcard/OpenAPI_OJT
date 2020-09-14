package com.hibernate.spring.config;

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

  // @Autowired private UserDetailService userDetailService;
  // @Autowired private LoginSuccessHandler loginSuccessHandler;


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("test"))
        .roles("USER");// 암호설정 다시 해야함
    System.out.println("{}hash : " + passwordEncoder().encode("test"));

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ================login================
    http.httpBasic().and().authorizeRequests().antMatchers("/users/{userId}")
        .access("@authenticationCheckHandler.checkUserId(authentication,#userId)")
        .antMatchers("/admin/db/**")
        .access("hasRole('ADMIN_MASTER') or hasRole('ADMIN') and hasRole('DBA')")
        .antMatchers("/register/**").hasRole("ANONYMOUS").and().formLogin()
        .loginPage("/pages/login").loginProcessingUrl("/login-processing")
        .defaultSuccessUrl("/pages/forum").usernameParameter("email").passwordParameter("password")
        // .successHandler(successHandler()).failureHandler(failureHandler())
        .permitAll();

    // =================logout===============
    http.logout().invalidateHttpSession(true);

    /*
     * httpBasic() : http 통신으로 인증받겠다 (ssl로도 가능) authorizeRequests() : 접근권한이 허용된 요청만 처리하겠다는 의미
     * antMatchers() : String 경로 아래의 요청은 뒤의 설정할 조건에 맞는 계정이 인증되어야지만 접근 가능하다는 것.(/ == web) access() :
     * 주어진 SpEL 표현식의 평가 결과가 true이면 접근을 허용 spEL= 스프링 표현언어 =>기본적으로 hasRole만 사용해서 globalconfig 에 설정한 것과
     * 일치하는 기준으로 엑세스를 설정할수 있지만 여러 경우가 존재했을때 hasRole 만으로는 부족하기 때문에 이와같은 형태를 이용해서 다양한 조건을 줄 수 있다.
     * formLogin() : form형태의 로그인 기능을 사용할 것이며 loginPage() 함수를 따로 지정하지 않을경우 "/login" 경로의 page가 스프링에서
     * 제공하는 default page 형태로 생성된다.
     */
  }

  // @Override
  // protected UserDetailsService userDetailsService() {
  // return userDetailService;
  // }



  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
