package com.enviro.assessment.grad001.kimeshNagiah.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.kimeshNagiah.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

	Transaction findByuserId(int userid);
}
