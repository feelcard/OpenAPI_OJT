package com.hibernate.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hibernate.spring.entity.member.Member;
import com.hibernate.spring.entity.subsidiary.Subsidiary;
import com.hibernate.spring.service.MemberService;
import com.hibernate.spring.service.SubsidiaryService;

@Controller
public class MemberResource {
  @Autowired
  MemberService memberService;
  @Autowired
  SubsidiaryService subsidiaryService;


  @GetMapping("/register")
  public ModelAndView registerMember(ModelAndView mv) {
    mv.setViewName("pages/forum");
    return mv;
  }

  @PostMapping("/register-processing")
  public ModelAndView registerProcessingMember(ModelAndView mv,
      @ModelAttribute("member") Member member) {
    memberService.save(member);
    System.out.println("member registered");
    mv.setViewName("pages/home");
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

  @GetMapping("/subsiList")
  public ModelAndView subsiList(ModelAndView mv) {
    List<Subsidiary> subsiList = subsidiaryService.getAllList();
    System.out.println("subsiList:" + subsiList);
    for (Subsidiary s : subsiList) {
      System.out.println(s.toString());
    }
    mv.addObject("subsiList", subsiList);
    mv.setViewName("pages/login");
    return mv;
  }

}
