package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.EmployeeInfo;

public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, Integer> {

}
