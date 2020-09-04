package com.hibernate.spring.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernate.spring.config.HibernateConfig;
import com.hibernate.spring.service.*;

public class DaoTest {

	
	@BeforeEach 
	@DisplayName("testBefore")
	public void setup() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		DisplayService displayService = context.getBean(DisplayService.class);
	}

	@Test
	@DisplayName("test")
	void testGet() {

		System.out.println("Test");
	}
}
