package com.hibernate.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.spring.dao.DisplayDao;
import com.hibernate.spring.entity.Display;

@Service
public class DisplayServiceImpl implements DisplayService {
	 
	@Autowired
	   private DisplayDao displayDao;
	
	@Transactional
	@Override
	public void add(Display display) {
		System.out.println("displayserviceimpl display insert : "+display.toString());
		displayDao.add(display);
		
	}
	@Transactional(readOnly = true)
	@Override
	public List<Display> listDisplays() {
		return displayDao.listDisplays();
	}

}
