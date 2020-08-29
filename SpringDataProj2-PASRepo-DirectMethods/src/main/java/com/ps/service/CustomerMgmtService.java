package com.ps.service;

import com.ps.dto.CustomerDTO;

public interface CustomerMgmtService {
	
	public Iterable<CustomerDTO> fetchAllRecordsSortByProperty(String property, boolean asc);
	public Iterable<CustomerDTO> fetchAllRecordsSortByProperty(boolean asc,String... properties);
	public Iterable<CustomerDTO> fetchRecordsByPageNoAndSize(int pageNo, int pageSize);
	public void fetchRecordsByPagination(int pageSize);
}
