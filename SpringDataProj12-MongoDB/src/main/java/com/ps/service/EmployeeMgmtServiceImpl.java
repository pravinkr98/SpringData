package com.ps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.document.Employee;
import com.ps.repo.EmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public String registerEmployee(Employee doc) {
		// use empRepo
		return "doc saved with id :: "+empRepo.save(doc).getEid();
	}

	@Override
	public List<Employee> findAllEmployees() {
		// use repo
		return empRepo.findAll();
	}

	@Override
	public Employee findEmpById(int id) {
		Optional<Employee> opt=null;
		// use repo
		opt=empRepo.findById(id);
		return opt.get();
	}

	@Override
	public String updateEmpSalary(int id, float bonus) {
		Optional<Employee> opt=null;
		Employee doc=null;
		// use repo
		opt=empRepo.findById(id);
		if(opt.isPresent()) {
			doc=opt.get();
			doc.setSalary(doc.getSalary()+bonus);
			return doc.getEid()+" salary is hike with :: "+bonus+" having new salary :: "+ empRepo.save(doc).getSalary();
		}
		return "employee not found";
	}

	@Override
	public String removeEmployee(int id) {
		Optional<Employee> opt=null;
		// use repo
		opt=empRepo.findById(id);
		if(opt.isPresent()) {
			empRepo.delete(opt.get());
			return id+" employee deleted";
		}
		return "employee not found";
	}

}
