package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
	public static List<Student> students=new ArrayList<Student>();
	static {
	Student s1=new Student(101, "Anju", 20);
	Student s2=new Student(102, "Anusree", 18);
	Student s3=new Student(103, "Hashna", 22);
	students.add(s1);
	students.add(s2);
	students.add(s3);
	}
	@GetMapping("/students")
	public List<Student> getStudent(){
		return students;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	@GetMapping("/token")
	public CsrfToken getcCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	

}
