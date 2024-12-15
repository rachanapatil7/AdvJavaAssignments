package com.learn.personApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.personApp.bean.Person;
import com.learn.personApp.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getPerson() {
//		Person person=new Person();
//		person.setId(1000);
//		person.setName("Ram");
//		person.setLocation("Fremont");
		return personService.getAllPerson();
	}
	
	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable(name="id") int  id) {
		return personService.getPersonById(id);
	}
	
	@PostMapping("/persons")
	public Person insert(@RequestBody Person person) {
		return personService.createPerson(person);
		
	}
	
	@PatchMapping("/persons/{id}")
	public Person updatePerson(@PathVariable(name="id") int  id) {
		return personService.updatePerson(id);
		
	}
	
	@DeleteMapping("/persons/{id}")
	public int delete(@PathVariable(name="id") int  id) {
		return personService.deletePersonById(id);
		//use update for delete
	}

}
