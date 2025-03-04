package com.ty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.EmployeeRepository;
import com.ty.dto.Employee;
@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	public List<Employee> getAllEmployee(){
		List<Employee> employee=(List<Employee>) repository.findAll();
		return employee;
	}
	
	public Employee addEmployee(Employee employee) {
		Employee saveEmployee=repository.save(employee);
		return saveEmployee;
	}
	public Employee updateEmployee(Employee employee, int id) {
		Optional<Employee> result=repository.findById(id);
		if(result.isPresent()) {
			Employee e=result.get();
			e.setName(employee.getName());
			e.setGender(employee.getGender());
			e.setAge(employee.getAge());
			e.setDesignation(employee.getDesignation());
			e.setExperience(employee.getExperience());
			return repository.save(e);
			}
		return null;	
	}
	
	public boolean deleteEmployee(int id) {
		Optional<Employee> employee=repository.findById(id);
		return true;
	}
	public Optional<Employee> getEmployeeById(int id) {
		Optional<Employee> employee=repository.findById(id);
		return employee;
	}


}
