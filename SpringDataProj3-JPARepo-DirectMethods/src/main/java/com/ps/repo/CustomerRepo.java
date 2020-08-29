package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
