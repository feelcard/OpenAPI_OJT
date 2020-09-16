package com.hibernate.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hibernate.spring.entity.subsidiary.Subsidiary;
import com.hibernate.spring.entity.subsidiary.SubsidiaryRepository;

@Service
public class SubsidiaryService {

  @Autowired
  SubsidiaryRepository subsidiaryRepository;

  public List<Subsidiary> getAllList() {
    return subsidiaryRepository.findAll();

  }

  public Subsidiary getSubsiByName(String subsiName) {

    return subsidiaryRepository.findBySubsiName(subsiName);

  }

}
