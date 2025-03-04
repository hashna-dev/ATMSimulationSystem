package com.ty.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ty.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
//	public List<Employee> findByName(String name);
//	public List<Employee> findByAgeAndPhno(int age, long phno);
//	public List<Employee> findByAgeLessThan(int age);
}
