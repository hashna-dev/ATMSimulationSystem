package com.ty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.StudentRepository;
import com.ty.student.Student;

@Component
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudent() {
        List<Student> students = (List<Student>) repository.findAll();
        return students;
    }

    public Student addStudent(Student student) {
        Student savedStudent = repository.save(student);
        return savedStudent;
    }

    public Student updateStudent(Student student, int id) {
        Optional<Student> result = repository.findById(id);
        if (result.isPresent()) {
            Student existingStudent = result.get();
            existingStudent.setName(student.getName());
            return repository.save(existingStudent);
        }
        return null; // Return null or handle error appropriately
    }

    public boolean deleteStudent(int id) {
        repository.deleteById(id);
        return true;
    }
    public Optional<Student> getStudentById(int id){
    	Optional<Student> student=repository.findById(id);
    	return student;
    }
}