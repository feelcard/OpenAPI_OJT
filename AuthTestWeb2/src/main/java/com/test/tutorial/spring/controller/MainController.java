package com.test.tutorial.spring.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.test.tutorial.spring.entity.User;
//import com.test.tutorial.spring.service.UserService;

@Controller
public class MainController {
//	@Autowired
//	UserService us;
	
	@GetMapping(value = "/")
	public String main() {
		
//		us.add(new User("firstName", "lastName", "email"));
		System.out.println("test Controller");
		
		return "intro";
	}
	
	


}
