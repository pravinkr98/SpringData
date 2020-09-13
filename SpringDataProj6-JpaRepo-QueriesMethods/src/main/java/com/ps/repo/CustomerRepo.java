package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ps.entity.Customer;

@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//----------------------------------Select bulk operations with Positional params------------------------------------
	@Query("FROM Customer")
	Iterable<Customer> getAllCustomers();
	
	@Query("FROM Customer WHERE CAddrs=?1")
	Iterable<Customer> getCustomersByCity(String city);
	
	@Query("FROM Customer WHERE BillAmt>=?1 AND BillAmt<=?2")
	Iterable<Customer> getCustomersByBillAmtRange(double start,double end);
	
	//-----------------------Select bulk operations with named params(Entitiy queries(all col values))-----------
	@Query("FROM Customer WHERE CAddrs IN(:city1,:city2,:city3)")
	Iterable<Customer> getCustomersByCityNames(@Param("city1")String city1,
																										@Param("city2")String city2,
																										@Param("city3")String city3);
	
	@Query("FROM Customer WHERE CName=:name")
	Iterable<Customer> getCustomersByName(String name);

	/*@Query("FROM Customer WHERE cNo>=?1 AND cNo<=:max")													//Invalid query
	Iterable<Customer> getCustomersByCnoRange(Integer min,@Param("max")Integer max);*/
	
	@Query("FROM Customer WHERE cNo>=?1 AND cNo<=?2")
	Iterable<Customer> getCustomersByCnoRange(Integer min,Integer max);
	
	//-----------------Select bulk operations with named params (Specific multiple cols-scalar queries-----------------------
	@Query("SELECT cNo,CName FROM Customer WHERE CAddrs=:cty")
	Iterable<Object[]> getCustomersValuesByCity(@Param("cty")String city);
	
	//------------------select bulk operations with named params (Specific single cols-Scalar queries----------------------
	@Query("SELECT billAmt FROM Customer WHERE CAddrs IN(:city1,:city2)")
	Iterable<Double> getBillAmtByCities(@Param("city1")String city1,
																					@Param("city2")String city2);
	
	//------------------------Single row select operations using HQL/JPQL (Entity query)----------------------------------
	@Query("FROM Customer WHERE CName=:name")		//assume "CNAME" col is having unique key
	Customer getCustomerByName(String name);

	//------------------------Single row select operations using HQL/JPQL (Scaler query)----------------------------------
	@Query("SELECT cNo,billAmt FROM Customer WHERE CName=:name")		//select specific multiple col of a record
	Object getCustomerValuesByName(String name);
	
	//------------------------Single row select operations using HQL/JPQL (Scaler query)----------------------------------
	@Query("SELECT billAmt FROM Customer WHERE CName=:name")		//select specific single col of a record
	Double getCustomerBillAmtByName(String name);
	
	//-------------------------Select query aggregate function----------------------------
	@Query("SELECT MAX(billAmt) FROM Customer")
	double getMaxBillAmount();
	
	@Query("SELECT MAX(billAmt),SUM(billAmt),AVG(billAmt),COUNT(*) FROM Customer")
	Object findAggregateResults();
	
	//---------------------------Update operation----------------------------------
	@Modifying
	@Query("UPDATE Customer SET billAmt=billAmt+:extraAmount WHERE CAddrs=:city")
	int modifyCustomerBillAmtByCity(String city,double extraAmount);
	
	//-----------------------------Delete operation-------------------------------
	@Modifying
	@Query("DELETE Customer WHERE CAddrs IS NULL")
	int deleteCustomerByCAddrsIfNull();
	
	//------------------------execute native SQL Select queries -------------------------------
	//@Query(nativeQuery = true, value="SELECT C_NO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS=?")
	//@Query(nativeQuery = true, value="SELECT C_NO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS=?1")
	@Query(nativeQuery = true, value="SELECT C_NO,CNAME,CADDRS,BILLAMT FROM CUSTOMER WHERE CADDRS=:addrs")
	Iterable<Customer> getCustomersByAddrs(String addrs);
	
	@Query(nativeQuery = true, value = "SELECT SYSDATE FROM DUAL")
	java.util.Date getSysDate();
	
	@Query(nativeQuery = true, value = "INSERT INTO CUSTOMER VALUES(HIBERNATE_SEQUENCE.NEXTVAL,?,?,?)")
	@Modifying
	int insertCustomerRecord(double bill,String addr,String name);
	
	//-------------------Calling PL/SQL procedure with IN param------------------------
	//@Query(nativeQuery = true,value="{call GET_CUSTOMER_BY_ADDRS(?)}")
	//@Query(nativeQuery = true,value="{call GET_CUSTOMER_BY_ADDRS(?1)}")
	@Query(nativeQuery = true,value="{call GET_CUSTOMER_BY_ADDRS(:addrs)}")
	Iterable<Customer> fetchCustomerDataByAddrs(String addrs);
	
}
