package com.ps.service;

import java.util.List;
import java.util.Optional;

import com.ps.dto.CustomerDTO;

public interface CustomerMgmtService {

	public String registerCustomer(CustomerDTO dto);
	public String registerGroupCustomers(List<CustomerDTO> listDTO);
	public String removeCustomerById(int id);
	public String removeGivenCustomers(Iterable<CustomerDTO> ItrDTO);
	public long fetchCustomerCount();
	public Iterable<CustomerDTO> fetchAllCustomers();
	public Optional<CustomerDTO> fetchCustomerById(int id);
	
}
