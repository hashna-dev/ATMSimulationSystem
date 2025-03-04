package com.ty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ty.dao.EmployeeDao;
import com.ty.entity.Employee;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(EmployeeApplication.class, args);
		EmployeeDao Dao=applicationContext.getBean(EmployeeDao.class);
//		Employee employee=new Employee();
//		employee.setId(101);
//		employee.setName("Hashna");
//		employee.setAge(22);
//		employee.setGender("Female");
//		
//		Employee employee1=new Employee();
//		employee1.setId(102);
//		employee1.setName("Ghani");
//		employee1.setAge(22);
//		employee1.setGender("Female");
//		
//		Employee employee2=new Employee();
//		employee2.setId(103);
//		employee2.setName("Meenu");
//		employee2.setAge(22);
//		employee2.setGender("Female");
//		
//		List<Employee> emp=new ArrayList<Employee>();
//		emp.add(employee);
//		emp.add(employee1);
//		emp.add(employee2);
//		Iterable <Employee> itr=Dao.saveAll(emp);
//		System.out.println(itr);
//		
//		Optional<Employee> result=Dao.findById(102);
//		Employee employee=result.get();
//		employee.setAge(23);
//		Employee emp=Dao.save(employee);
//		System.out.println(emp);
//		
//		Iterable<Employee>itr=Dao.findAll();
//		Iterator< Employee> iterator=itr.iterator();
//		while (iterator.hasNext()) {
//			Employee employee = iterator.next();
//			System.out.println(employee);
		
//		Dao.deleteById(102);
//		System.out.println("Data deleted");
			
//		Dao.deleteAll();
//		Dao.findByName("")
		}
		
	
	}


