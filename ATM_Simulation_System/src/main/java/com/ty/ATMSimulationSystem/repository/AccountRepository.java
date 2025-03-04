package com.ty.mySpringBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.mySpringBank.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByaccountNumber(String accountNumber);
	
}
