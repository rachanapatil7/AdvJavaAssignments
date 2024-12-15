package com.learn.personApp.dao;

import java.util.List;

import com.learn.personApp.bean.Person;

public interface PersonDao {
	public List<Person> findAll();

	public Person findById(int id);

	public int insert(Person person);

	public int deleteById(int id);

	public int update(int id);
}
