package com.ps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ps.entity.PhoneNumber;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {
	
	@Query("SELECT p.userId,p.name,p.addrs,c.mobileNo,c.provider,c.type FROM User p INNER JOIN p.phones c")
	List<Object[]> fetchDataByJoins();

}
