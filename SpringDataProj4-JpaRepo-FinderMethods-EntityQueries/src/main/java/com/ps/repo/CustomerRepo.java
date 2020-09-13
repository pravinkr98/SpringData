package com.ps.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	/*SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS=?
	=>if no condition is taken default condition is where "is" or "="
			if wrong property name is taken in findByxxx() method then we get
				Caused by: org.springframework.data.mapping.PropertyReferenceException: 
					No property caddrs found for type Customer! Did you mean 'CAddrs','cAddrs'?	*/
	public List<Customer> findByCAddrs(String addrs);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME=?
	//public List<Customer> findByCName(String name);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT>?
	public List<Customer> findBybillAmtGreaterThan(double amount);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT<?
	public List<Customer> findBybillAmtLessThan(double amount);

	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE 'Ram%'
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE '____'
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE '____%'
	public List<Customer> findByCNameLike(String initChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE 'R%'
	public List<Customer> findByCNameStartingWith(String nameChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE '%h'
	public List<Customer> findByCNameEndingWith(String nameChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME LIKE '%m%'
	public List<Customer> findByCNameContaining(String nameChars);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS IS NULL
	public Iterable<Customer> findByCAddrsIsNull();
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS IS NOT NULL
	public Iterable<Customer> findByCAddrsIsNotNull();	
	public Iterable<Customer> findByCAddrsNotNull();	
	
	//--------------------------Working with more than one property and condition------------------------------
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT>40000 AND BILLAMT<70000
	//NotWorking-->//public Iterable<Customer> findBybillAmtGreaterThanEqualAndbillAmtLessThanEqual(double start, double end);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT BETWEEN (40000,70000)
	public Iterable<Customer> findBybillAmtBetween(double start, double end);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME='Raja' OR CADDRS='Hyd'
	public Iterable<Customer> findByCNameEqualsOrCAddrsEquals(String name,String addrs);
	public Iterable<Customer> findByCNameOrCAddrs(String name,String addrs);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE BILLAMT BETWEEN(40000,80000) ORDER BY DESC
	//public Iterable<Customer> findByBillAmtBetweenOrderByCNameDesc(double min,double max);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS <>'Hyd'
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS !='Hyd'
	public Iterable<Customer> findByCAddrsNot(String addrs);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS IN ('Hyd','Viizag','Delhi')
	public Iterable<Customer> findByCAddrsIn(Collection<String> cities);
	
	//SELECT CNO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CNAME='Raja' 	//assume CNAME having UK Constraints
	public Customer findByCName(String name);	
	
}
