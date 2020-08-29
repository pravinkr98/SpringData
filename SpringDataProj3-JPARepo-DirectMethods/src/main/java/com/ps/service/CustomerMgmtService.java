package com.ps.service;

import java.util.List;

import com.ps.dto.CustomerDTO;

public interface CustomerMgmtService {
	
	public List<CustomerDTO> fetchAllRecordsByGivenExampleDTO(CustomerDTO dto);
	public String removeAllCustomers();
}
