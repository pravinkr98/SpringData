package com.ps.service;

import java.util.List;

import com.ps.document.Employee;

public interface EmployeeMgmtService {

	public String registerEmployee(Employee doc);
	public List<Employee> findAllEmployees();
	public Employee findEmpById(int id);
	public String updateEmpSalary(int id,float bonus);
	public String removeEmployee(int id);
}
