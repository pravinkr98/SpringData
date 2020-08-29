package com.ps.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ps.entity.Customer;

public interface CustomerRepo extends PagingAndSortingRepository<Customer, Integer> {

}
