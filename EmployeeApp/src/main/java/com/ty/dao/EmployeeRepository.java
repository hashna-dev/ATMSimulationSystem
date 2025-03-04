package com.ty.dao;

import org.springframework.data.repository.CrudRepository;

import com.ty.dto.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
