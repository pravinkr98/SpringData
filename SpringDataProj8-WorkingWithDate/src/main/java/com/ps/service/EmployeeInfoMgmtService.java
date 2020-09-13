package com.ps.service;

import java.util.List;

import com.ps.dto.EmployeeInfoDTO;

public interface EmployeeInfoMgmtService {

	public Integer registerEmployee(EmployeeInfoDTO dto);
	public List<EmployeeInfoDTO> fetchAllEmployeeInfo();
	
}
