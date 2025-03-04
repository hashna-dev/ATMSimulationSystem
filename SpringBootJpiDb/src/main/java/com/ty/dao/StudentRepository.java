package com.ty.dao;

import org.springframework.data.repository.CrudRepository;

import com.ty.student.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	

}
