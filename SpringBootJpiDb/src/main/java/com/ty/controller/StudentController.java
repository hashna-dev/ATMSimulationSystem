package com.ty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.service.StudentService;
import com.ty.student.Student;

@RestController

public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> students = service.getAllStudent();
		if (students.isEmpty()) {
			return ResponseEntity.status(HttpStatus.GONE).build();
		}
		return ResponseEntity.of(Optional.of(students));
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		Student savedStudent = service.addStudent(student);
		return savedStudent;
	}

	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		Student result = service.updateStudent(student, id);
		return result;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
		boolean out = service.deleteStudent(id);
		if (out) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}