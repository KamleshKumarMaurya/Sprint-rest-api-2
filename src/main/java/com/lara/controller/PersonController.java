package com.lara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lara.dao.Person;
import com.lara.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;

	@GetMapping("/")
	public List<Person> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Person> save(@RequestBody Person person){
		service.save(person);
		return new ResponseEntity<Person>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> update(@PathVariable int id,@RequestBody Person person1){
		Person person = service.findById(id);
		person.setId(person1.getId());
		person.setName(person1.getName());
		person.setAge(person1.getAge());
		person.setJod(person1.getJod());
		person.setSalary(person1.getSalary());
		service.update(person);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public Person findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/byName/{name}")
	public List<Person> findByName(@PathVariable String name) {
		return service.findByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Person> delete(@PathVariable int id){
		service.deletById(id);
		return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
	}
}
