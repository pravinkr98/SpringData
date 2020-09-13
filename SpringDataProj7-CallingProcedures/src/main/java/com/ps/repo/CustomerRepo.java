package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ps.entity.Customer;

//@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
		
	//-------------------Calling PL/SQL procedure -----------------------
		
	@Procedure(procedureName = "GET_CUSTOMERS_COUNT_BY_ADDRS")
	int fetchCustomersCountByAddrs(String addrs);
	
	@Procedure
	int GET_CUSTOMERS_COUNT_BY_ADDRS(String addrs);
	
}
