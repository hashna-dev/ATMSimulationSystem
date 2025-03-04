package com.ty.dao;

import org.springframework.data.repository.CrudRepository;

import com.ty.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {
	

}
