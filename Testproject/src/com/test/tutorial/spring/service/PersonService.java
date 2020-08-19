package com.test.tutorial.spring.service;

import java.util.List;

import com.test.tutorial.spring.entity.Person;

public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
}