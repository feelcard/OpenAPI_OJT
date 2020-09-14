package com.hibernate.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hibernate.spring.entity.display.Display;
import com.hibernate.spring.service.DisplayService;

@Controller
public class DisplayResource {

  @Autowired
  DisplayService displayService;

  @GetMapping(name = "/")
  public ModelAndView PutController(ModelAndView mv) {

    List<Display> lists = displayService.listDisplays();

    for (Display display : lists) {
      System.out.println(display);
    }
    mv.addObject("dlist", lists);
    mv.setViewName("pages/login");
    return mv;
  }

}
