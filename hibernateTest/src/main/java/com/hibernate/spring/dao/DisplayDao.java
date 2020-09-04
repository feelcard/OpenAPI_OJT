package com.hibernate.spring.dao;

import java.util.List;

import com.hibernate.spring.entity.Display;

public interface DisplayDao {
	void add(Display display);
	List<Display> listDisplays();
	
	
}
