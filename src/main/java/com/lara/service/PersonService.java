package com.lara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lara.dao.Person;
import com.lara.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repo;
	
	public List<Person> getAll(){
		 return repo.findAll();
	}
	
	public Person save(Person person) {
		repo.save(person);
		return person;
	}
	
	public Person update(Person person) {
		repo.save(person);
		return person;
	}
	
	public Person findById(int id) {
		return repo.findById(id).orElse(null); 
	}
	
	public void deletById(int id) {
		repo.deleteById(id);
	}
	
	public List<Person> findByName(String name) {
		return repo.findByName(name);
	}
 
}
