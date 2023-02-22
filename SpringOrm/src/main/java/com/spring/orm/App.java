package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        while(true) {
        	System.out.println("*****Welcome to spring orm project*****\n"
        			+ "PRESS 1 to add a new student\n"
        			+ "PRESS 2 to display all students\n"
        			+ "PRESS 3 display a particular student\n"
        			+ "PRESS 4 delete a student\n"
        			+ "PRESS 5 to update student data\n"
        			+ "PRESS 6 to exit\n");
        	
        	int inp = sc.nextInt();
  
        	if(inp == 6) {
        		System.out.println("Thank you!!!!");
        		break;
        	}
        	
        	if(inp == 1) {
        		System.out.println("Enter student id: ");
        		int id = sc.nextInt();
        		
        		System.out.println("Enter student name: ");
        		String name = sc.next();
        		
        		System.out.println("Enter student City: ");
        		String city = sc.next();
        		
        		Student st = new Student(id, name, city);
        		
        		int res = studentDao.insert(st);
        		System.out.println("Entered student: " + res);
        	}else if(inp == 2) {
        		List<Student> li = studentDao.getAllStudents();
        		
        		for(Student s: li) {
        			System.out.println(s);
        		}
        	}else if(inp == 3) {
        		System.out.println("Enter student id: ");
        		int id = sc.nextInt();
        		
        		Student st = studentDao.getStudent(id);
        		System.out.println(st);
        	}else if(inp == 4) {
        		System.out.println("Enter student id: ");
        		int id = sc.nextInt();
        		
        		studentDao.deleteStudent(id);
        	}else {
        		System.out.println("Enter student id: ");
        		int id = sc.nextInt();
        		
        		System.out.println("Enter student name: ");
        		String name = sc.next();
        		
        		System.out.println("Enter student City: ");
        		String city = sc.next();
        		
        		Student st = new Student(id, name, city);
        		
        		studentDao.updateStudent(st);
        	}
        }
        
        
    }
}
