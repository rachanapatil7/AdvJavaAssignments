package com.learn.personApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learn.personApp.bean.Person;

@Repository("personJdbcDao")
public class PersonJdbcDao implements PersonDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<Person>(Person.class));
	}
	
public Person findById(int id) {
		
		return jdbcTemplate.queryForObject("select * from person where id=?", new PersonRowMapper(),id);
	}
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person=new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			return person;
		}
		
	}

	public int insert(Person person) {
		
		return jdbcTemplate.update("insert into person(id,name,location) values (?,?,?)",person.getId(),person.getName(),person.getLocation());
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE from person where id=?",id);
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
 }
