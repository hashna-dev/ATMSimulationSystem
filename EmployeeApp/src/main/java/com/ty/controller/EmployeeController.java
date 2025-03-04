package com.ty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.dto.Employee;
import com.ty.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employee = service.getAllEmployee();
		if (employee.isEmpty()) {
			return ResponseEntity.status(HttpStatus.GONE).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
	@PostMapping("/emp")
	public Employee addStudent(@RequestBody Employee student) {
		Employee savedStudent = service.addEmployee(student);
		return savedStudent;
	}

	@PutMapping("/emp/{id}")
	public Employee updateStudent(@RequestBody Employee employee, @PathVariable("id") int id) {
		Employee result = service.updateEmployee(employee, id);
		return result;
	}

	@DeleteMapping("/emp/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
		boolean out = service.deleteEmployee(id);
		if (out) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	@GetMapping("/emp/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
		Optional<Employee>emp=service.getEmployeeById(id);
		return emp ;
	}

	

}
