package com.ty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ty.dao.UserDao;
import com.ty.entity.User;

@SpringBootApplication
public class MySpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(MySpringDataJpaApplication.class, args);
		UserDao dao=context.getBean(UserDao.class);
		User user=new User();
		user.setId(1);
		user.setName("Hashna");
		user.setGender("Female");
		User result=dao.save(user);
		System.out.println(result);
	}

}
