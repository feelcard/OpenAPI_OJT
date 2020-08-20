package com.test.tutorial.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // xml 파일의 <annotation-driven />
@ComponentScans(value = {@ComponentScan("com.test.tutorial.spring.config"),@ComponentScan("com.test.tutorial.spring.controller")})
public class ServletConfig  extends WebMvcConfigurerAdapter{
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	    
	    @Bean
	    public InternalResourceViewResolver internalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        System.out.println("ViewResolver setted");
	        return resolver;
	    }
	    
//	    @Override // 리소스파일 경로
//	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	    }




}
