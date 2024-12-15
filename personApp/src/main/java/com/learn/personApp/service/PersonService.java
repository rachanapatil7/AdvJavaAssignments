package com.learn.personApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.personApp.bean.Person;
import com.learn.personApp.dao.PersonDao;
import com.learn.personApp.dao.PersonJdbcDao;

@Service
public class PersonService {
	
	@Autowired
	@Qualifier("personJPADao")
	private PersonDao personDao;
	//private PersonJdbcDao personJdbcDao;
	
	public List<Person> getAllPerson(){
		return personDao.findAll();
		}

	public Person getPersonById(int id) {
		
		return personDao.findById(id);
	}

	public Person createPerson(Person person) {
		int insert=personDao.insert(person);
		if(insert>0) {
			return person;
		}
		return null;
	}

	public int deletePersonById(int id) {
		int delete=personDao.deleteById(id);
		System.out.println(delete);
//		if(delete>0) {
//			return "Success";
//		}
//		return "Failure";
		return delete;
	}

	public Person updatePerson(int id) {
		int update=personDao.update(id);
		return null;
	}

	
}
