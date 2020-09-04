package com.hibernate.spring;



import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;

import javax.naming.Context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
import com.hibernate.spring.config.HibernateConfig;
import com.hibernate.spring.entity.Display;
import com.hibernate.spring.service.DisplayService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
		= new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		DisplayService displayService = context.getBean(DisplayService.class);
		displayService.add(new Display(UUID.randomUUID().toString(),"name1","status1","url1","Member1","2020-01-01","Admin","2020-02-02"));
		displayService.add(new Display(UUID.randomUUID().toString(),"name2","status2","url2","Member2","2020-01-02","Admin","2020-02-02"));
		displayService.add(new Display(UUID.randomUUID().toString(),"name3","status3","url3","Member3","2020-01-03","Admin","2020-02-02"));
		displayService.add(new Display(UUID.randomUUID().toString(),"name4","status4","url4","Member4","2020-01-04","Admin","2020-02-02"));
		
	

		
		
		List<Display> displays = displayService.listDisplays();
		for(Display display : displays ) {
			System.out.println(display.toString());
		}
	}
	
	
	

}
