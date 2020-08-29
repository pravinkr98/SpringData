package com.ps.repo;

import org.springframework.data.repository.CrudRepository;

import com.ps.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
