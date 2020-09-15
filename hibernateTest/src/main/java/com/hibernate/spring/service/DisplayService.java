package com.hibernate.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hibernate.spring.entity.display.Display;
import com.hibernate.spring.entity.display.DisplayRepository;

@Service
public class DisplayService {

  @Autowired
  DisplayRepository displayRepository;

  public void add(Display display) {
    System.out.println(" displayserviceimpl display insert : " + display.toString());
    displayRepository.save(display);

  }

  public List<Display> listDisplays() {
    return displayRepository.findAll();
  }

}
