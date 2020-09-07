package com.hibernate.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.hibernate.spring.config.HibernateConfig;
import com.hibernate.spring.service.DisplayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HibernateConfig.class, loader=AnnotationConfigContextLoader.class)
public class DaoTest {

	
	@BeforeEach 
	@DisplayName("testBefore")
	public void setup() {
	
	}

	@Test
	@DisplayName("test")
	void testGet() throws SQLException {
		
		System.out.println("Test");
	}
}
