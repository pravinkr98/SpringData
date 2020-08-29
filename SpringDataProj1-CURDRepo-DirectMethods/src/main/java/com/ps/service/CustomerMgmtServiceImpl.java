package com.ps.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dto.CustomerDTO;
import com.ps.entity.Customer;
import com.ps.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		System.out.println(custRepo.getClass()+"------->     "+Arrays.toString(custRepo.getClass().getInterfaces()));
		Customer entity=null;
	
		entity=new Customer();
		//copy dto into entity obj
		BeanUtils.copyProperties(dto, entity);		
		//user Repo
		entity=custRepo.save(entity);
		//return message
		return (entity==null)?"Customer Registration failed":"Customer Registration successfull with id : "+entity.getCNo();
	}

	@Override
	public String registerGroupCustomers(List<CustomerDTO> listDTO) {
		List<Customer> listEntities=new ArrayList<>();
		List<Customer> listEntities1=new ArrayList<>();
		String ids=new String();
		//convert listDTO to listEntity
		listDTO.forEach(dto->{
			Customer entity=new Customer();
			BeanUtils.copyProperties(dto, entity);
			listEntities.add(entity);
		});
		//use repo
		listEntities1=(List<Customer>) custRepo.saveAll(listEntities);
		
		//ids=listEntities1.stream().map(e->e.getCNo()).collect(Collectors.toList()).toString();  //using Java8 Stream api
		for(Customer e:listEntities1){			//using Java8 
			ids=ids+","+e.getCNo();
		}
		
		return listEntities1!=null?"Customer group is Registered with id : "+ids:"Customer group is not registered";
	}

	@Override
	public String removeCustomerById(int id) {
		boolean forDelete=false;
		//use repo
		forDelete=custRepo.existsById(id);
		if(forDelete) {		
			forDelete=false;
			custRepo.deleteById(id);
			forDelete=true;
		}		
		return forDelete?"Customer with id: "+id+" is deleted":"Customer with id: "+id+" is not found for deletion";
	}

	@Override
	public String removeGivenCustomers(Iterable<CustomerDTO> ItrDTO) {
		Iterable<Customer> ItrEntities=new ArrayList<>();
		Iterable<Customer> ItrEntities1=null;
		boolean deleted=false;		
		//String ids="";
		
		//convert ItrDTO to ItrEntity
		ItrDTO.forEach(dto->{
			Customer entity=new Customer();
			BeanUtils.copyProperties(dto, entity);
			((List<Customer>) ItrEntities).add(entity);
		});
		//cheking for exists or not
		//use repo	
		ItrEntities1=custRepo.findAllById((Iterable<Integer>) ((Collection<Customer>) ItrEntities).stream().map(e->e.getCNo()).collect(Collectors.toList()));
				
		//deletion		
		if(ItrEntities1!=null) {
			custRepo.deleteAll(ItrEntities);
			deleted=true;
		}
		//keep all id in ids
		//ids=(Iterator<Integer>) ((Collection<Customer>) ItrEntities).stream().map(e->e.getCNo()).collect(Collectors.toList()).toString();
		return deleted?"Given all customers are deleted":"Given customers are not deleted";
	}

	@Override
	public long fetchCustomerCount() {	
		//use repo
		return custRepo.count();
	}

	@Override
	public Iterable<CustomerDTO> fetchAllCustomers() {
		Iterable<CustomerDTO> itrDTO=new ArrayList<>();
		Iterable<Customer> itrEntities=null;
		//use repo
		itrEntities=custRepo.findAll();
		//convert itrEntity to itrDTO
				itrEntities.forEach(entity->{
					CustomerDTO dto=new CustomerDTO();
					BeanUtils.copyProperties(entity, dto);
					((List<CustomerDTO>) itrDTO).add(dto);
				});
		
		return itrDTO;
	}

	@Override
	public Optional<CustomerDTO> fetchCustomerById(int id) {
		Optional<Customer> optEntity=null;
		Optional<CustomerDTO> optDTO=Optional.of(new CustomerDTO());
		
		//use repo
		optEntity=custRepo.findById(id);
		if(optEntity.isPresent()) {
			BeanUtils.copyProperties(optEntity.get(), optDTO.get());
		}
		else {
			optDTO=optDTO.empty();
		}
		
		return optDTO;
	}

}
