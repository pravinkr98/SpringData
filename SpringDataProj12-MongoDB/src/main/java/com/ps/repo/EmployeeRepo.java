package com.ps.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ps.document.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}
