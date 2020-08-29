package com.ps.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ps.dto.CustomerDTO;
import com.ps.entity.Customer;
import com.ps.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public List<CustomerDTO> fetchAllRecordsByGivenExampleDTO(CustomerDTO dto) {
		Customer entity=null;
		Example<Customer> example=null;
		List<Customer> listEntities=null;
		List<CustomerDTO> listDTO=new ArrayList<>();
		
		//copy dto to entity
		entity=new Customer();
		BeanUtils.copyProperties(dto, entity);
		//prepare Example class object
		example=Example.of(entity);
		
		//use Repo
		listEntities=custRepo.findAll(example);
		
			//copy itrEntities into itrDTO
			listEntities.forEach(ent->{
				CustomerDTO dto1=new CustomerDTO();
				BeanUtils.copyProperties(ent, dto1);
				listDTO.add(dto1);
			});
			
			return listDTO;		
		
	}

	@Override
	public String removeAllCustomers() {
		boolean deleted=false;
		//use repo
		if(custRepo.count()>=1) {
			custRepo.deleteAllInBatch();
			deleted=true;
		}		
		return deleted?"All Customer records are deleted":"No Customer records are found for deletion";
	}

}
