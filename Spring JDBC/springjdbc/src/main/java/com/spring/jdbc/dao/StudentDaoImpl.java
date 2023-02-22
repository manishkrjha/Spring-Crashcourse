package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(Student student) {
		// Inserting data
		String query = "INSERT INTO STUDENT(id, name, city) VALUES(?,?,?)";
		int res = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return res;
	}

	public int change(Student student) {
//		Updating tuple
		String query = "update student set name=?, city=? where id=?";
		int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return res;
	}

	public int remove(Student student) {
		// Removing user
		String query = "delete from student where id=?";
		int res = this.jdbcTemplate.update(query, student.getId());
		return res;
	}

	public Student getStudent(int studentId) {
		// Selecting one student\
		
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		
		return student;
	}

	public List<Student> getAllStudents() {
		String query = "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> allStudents = this.jdbcTemplate.query(query, rowMapper);
		return allStudents;
	}
}
