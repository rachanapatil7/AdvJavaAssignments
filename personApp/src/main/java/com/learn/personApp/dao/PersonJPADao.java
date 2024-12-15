package com.learn.personApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.personApp.bean.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository("personJPADao")
@Transactional
public class PersonJPADao implements PersonDao {
	
	@Autowired
	EntityManager entitymanager;

	@Override
	public List<Person> findAll() {
		//using JPQL
		TypedQuery<Person> query= entitymanager.createQuery("select p From Person p",Person.class);
		return query.getResultList();
		//using native query
//		return entitymanager.createNativeQuery("select * from person",Person.class).getResultList();
	}

	@Override
	public Person findById(int id) {
		
		return entitymanager.find(Person.class,id);
	}

	@Override
	public int insert(Person person) {
		entitymanager.persist(person);
		return 0;
	}
	
	@Override
	public int update(int id) {
		Person p=entitymanager.find(Person.class, id);
		System.out.println(p);
		return 0;
	}

	@Override
	public int deleteById(int id) {
		Person entity = entitymanager.find(Person.class, id);
        if (entity != null) {
            entitymanager.remove(entity);
        }
		return 0;
	}

}
