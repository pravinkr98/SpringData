package com.ps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//----------------------------------Static Projections------------------------------------
	interface ResultsView1 extends View{
		Integer getcNo();
		String getCName();
	}
	
	//SELECT CNO,CNAME FROM CUSTOMER WHERE CADDRS=?
	//List<ResultsView1> findByCAddrs(String add);

	interface ResultsView2 extends View{
		String getCName();
		double getBillAmt();
	}
	
	//SELECT CNAME,BILLAMT FROM CUSTOMER WHERE CNO BETWEEN(1,5)
	List<ResultsView2> findBycNoBetween(int min,int max);
	
	//--------------------------------------Dynamic Projections------------------------------------------------
	//design the method with generic
	//<T>List<T> findByCAddrs(String add, Class<T> clazz);
	<T extends View>List<T> findByCAddrs(String add, Class<T> clazz);
	
	interface View{	}		//Marker interface
}
