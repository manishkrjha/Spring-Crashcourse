package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//Insert Student [Transaction is for write operations]
	@Transactional
	public int insert(Student student) {
		Integer res = (Integer)this.hibernateTemplate.save(student);
		return res;
	}
	
	//Display student
	public Student getStudent(int studentId) {
		Student st = this.hibernateTemplate.get(Student.class, studentId);
		return st;
	}
	
	//Display all students
	public List<Student> getAllStudents(){
		List<Student> li = this.hibernateTemplate.loadAll(Student.class);
		return li;
	}
	
	//Delete student
	@Transactional
	public void deleteStudent(int studentId) {
		Student st = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(st);
	}
	
	//update student
	@Transactional
	public void updateStudent(Student st) {
		this.hibernateTemplate.update(st);
		System.out.println("Student updated");
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
