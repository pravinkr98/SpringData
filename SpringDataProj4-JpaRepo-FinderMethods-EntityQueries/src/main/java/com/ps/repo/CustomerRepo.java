package com.ps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	/*SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS=?
	=>if no condition is taken default condition is where "is" or "="
			if wrong property name is taken in findByxxx() method then we get
				Caused by: org.springframework.data.mapping.PropertyReferenceException: 
					No property caddrs found for type Customer! Did you mean 'CAddrs','cAddrs'?	*/
	//public List<Customer> findBycAddrs(String addrs);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME=?
	//public List<Customer> findBycName(String name);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT>?
	//public List<Customer> findBybillAmtGreaterThan(double amount);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT<?
	//public List<Customer> findBybillAmtLessThan(double amount);

	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE 'Ram%'
	//public List<Customer> findBycNameLike(String initChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE 'R%'
	//public List<Customer> findBycNameStartingWith(String nameChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE '%h'
	//public List<Customer> findBycNameEndingWith(String nameChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE '%m%'
	//public List<Customer> findBycNameContaining(String nameChars);
	
	//public List<Customer> findBycAddrsIsNull();
	
	//public List<Customer> findBycAddrsIsNotNull();
	
	public List<Customer> findBycAddrsNotNull();
}
