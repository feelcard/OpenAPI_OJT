package com.hibernate.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hibernate.spring.entity.member.Member;
import com.hibernate.spring.service.MemberService;

@Controller
public class MemberResource {
  @Autowired
  MemberService memberService;

  @GetMapping("/register")
  public ModelAndView registerMember(ModelAndView mv, Member memberTO) {
    System.out.println("member registered");
    mv.setViewName("pages/forum");
    return mv;
  }

  @GetMapping("/signup")
  public ModelAndView registerMove(ModelAndView mv) {
    System.out.println("test");
    mv.setViewName("pages/register");
    return mv;
  }

  @GetMapping("/")
  public ModelAndView mainPage(ModelAndView mv) {
    mv.setViewName("pages/home");
    return mv;
  }

  @GetMapping("/home")
  public ModelAndView homePage(ModelAndView mv) {
    mv.setViewName("pages/home");
    return mv;
  }

  @GetMapping("/user_info")
  public ModelAndView userInfoPage(ModelAndView mv) {
    mv.setViewName("pages/user_info");
    return mv;
  }

  @GetMapping("/login")
  public ModelAndView loginProcessing(ModelAndView mv) {


    mv.setViewName("pages/login");
    return mv;
  }

}
