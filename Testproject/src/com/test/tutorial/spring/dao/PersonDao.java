package com.test.tutorial.spring.dao;

import java.util.List;

import com.test.tutorial.spring.entity.Person;

public interface PersonDao {
   void add(Person person);
   List<Person> listPersons();
}