package com.ty.mySpringBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.mySpringBank.model.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByAccountId(int id);

}
