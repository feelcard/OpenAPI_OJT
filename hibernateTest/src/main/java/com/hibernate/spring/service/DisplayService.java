package com.hibernate.spring.service;

import java.util.List;

import com.hibernate.spring.entity.Display;

public interface DisplayService {

	void add(Display display);
	List<Display> listDisplays();
}
