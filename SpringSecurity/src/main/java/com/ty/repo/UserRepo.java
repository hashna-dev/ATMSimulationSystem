package com.ty.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ty.model.Users;
@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {
	
	Users findByUsername(String username);

}
