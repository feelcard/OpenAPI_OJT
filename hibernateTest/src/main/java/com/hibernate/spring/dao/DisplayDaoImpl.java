package com.hibernate.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.spring.entity.Display;

@Repository
public class DisplayDaoImpl implements DisplayDao{

	 @Autowired
	 private SessionFactory sessionFactory;
	
	@Override
	public void add(Display display) {
		sessionFactory.getCurrentSession().save(display);
		
	}

	@Override
	public List<Display> listDisplays() {
		 @SuppressWarnings("unchecked")
	      TypedQuery<Display> query=sessionFactory.getCurrentSession().createQuery("from Display");
	      return query.getResultList();
	}

}
