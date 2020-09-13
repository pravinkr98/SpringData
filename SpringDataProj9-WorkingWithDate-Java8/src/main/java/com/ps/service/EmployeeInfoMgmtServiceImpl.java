package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dto.EmployeeInfoDTO;
import com.ps.entity.EmployeeInfo;
import com.ps.repo.EmployeeInfoRepo;

@Service("empService")
public class EmployeeInfoMgmtServiceImpl implements EmployeeInfoMgmtService {
	
	@Autowired
	private EmployeeInfoRepo empRepo;

	@Override
	public Integer registerEmployee(EmployeeInfoDTO dto) {
		EmployeeInfo entity=null;
		
		//convert dto to entity
		entity=new EmployeeInfo();
		BeanUtils.copyProperties(dto, entity);
		//use repo
		return empRepo.save(entity).getEid();
		
	}

	@Override
	public List<EmployeeInfoDTO> fetchAllEmployeeInfo() {
		List<EmployeeInfo> listEntity=null;
		List<EmployeeInfoDTO> listDTO=new ArrayList<>();
		
		// use repo
		listEntity=empRepo.findAll();
		//convert listEntity to listDTO
		listEntity.forEach(entity->{
			EmployeeInfoDTO dto=new EmployeeInfoDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

}
