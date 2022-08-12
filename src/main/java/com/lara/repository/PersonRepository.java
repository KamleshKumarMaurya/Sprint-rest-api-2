package com.lara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lara.dao.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	public List<Person> findByName(String name);
}
