package com.ps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ps.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	//@Query("SELECT p.userId,p.name,p.addrs,c.mobileNo,c.provider,c.type FROM User p INNER JOIN p.phones c")
	//@Query("SELECT p.userId,p.name,p.addrs,c.mobileNo,c.provider,c.type FROM User p LEFT JOIN p.phones c")
	//@Query("SELECT p.userId,p.name,p.addrs,c.mobileNo,c.provider,c.type FROM User p RIGHT JOIN p.phones c")
	@Query("SELECT p.userId,p.name,p.addrs,c.mobileNo,c.provider,c.type FROM User p FULL JOIN p.phones c")
	List<Object[]> fetchDataByJoins();
	
	@Query("SELECT p.userId,p.name,p.addrs,c.mobileNo,c.provider,c.type FROM User p FULL JOIN p.phones c WHERE p.addrs=?1")
	List<Object[]> fetchDataByJoinsAddrs(String addr);
	
}
