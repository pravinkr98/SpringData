package com.ps.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ps.dto.CustomerDTO;
import com.ps.entity.Customer;
import com.ps.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public Iterable<CustomerDTO> fetchAllRecordsSortByProperty(String property, boolean asc) {
		Iterable<Customer> itrEntities=null;
		Iterable<CustomerDTO> itrDTO=new ArrayList<>();
		
		// use repo
		itrEntities=custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, property));
		
		if(itrEntities!=null) {			
			//copy itrEntities into itrDTO
			itrEntities.forEach(entity->{
				CustomerDTO dto=new CustomerDTO();
				BeanUtils.copyProperties(entity, dto);
				((ArrayList<CustomerDTO>) itrDTO).add(dto);
			});
		}
		
		return itrDTO;
	}

	@Override
	public Iterable<CustomerDTO> fetchAllRecordsSortByProperty(boolean asc, String... properties) {
		Iterable<Customer> itrEntities=null;
		Iterable<CustomerDTO> itrDTO=new ArrayList<>();
		// use repo
		itrEntities=custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, properties));
		
		//copy itrEntities into itrDTO
		if(itrEntities!=null) {			
			itrEntities.forEach(entity->{
				CustomerDTO dto=new CustomerDTO();
				BeanUtils.copyProperties(entity, dto);
				((ArrayList<CustomerDTO>) itrDTO).add(dto);
			});
		}
		
		return itrDTO;
	}

	@Override
	public Iterable<CustomerDTO> fetchRecordsByPageNoAndSize(int pageNo, int pageSize) {
		Pageable pageable=null;
		Page<Customer> page=null;
		//Slice<Customer> slice=null;
		Iterable<Customer> itrEntities=null;
		Iterable<CustomerDTO> itrDTO=new ArrayList<>();
		boolean records=false;
		
		pageable=PageRequest.of(pageNo, pageSize);
		// use repo
		page=custRepo.findAll(pageable);
		//slice=custRepo.findAll(pageable);
		//convert page obj into iterable obj
		itrEntities=page.getContent();
		//itrEntities=slice.getContent();
		
		//System.out.println(slice.getNumber()+"     "+slice.hasContent()+"     "+slice.isEmpty()+"     "+slice.isFirst()+"     "+slice.getNumberOfElements());
		System.out.println(page.getNumber()+"     "+page.hasContent()+"     "+page.isEmpty()+"     "+page.isFirst()+"     "+page.getNumberOfElements()+"     "+page.getSize()+"     "+page.getTotalElements()+"     "+page.getTotalPages());
		
		//System.out.println(Arrays.asList(itrEntities).toString());  //.contains("Customer"));
		//copy itrEntities into itrDTO
		if(Arrays.asList(itrEntities).toString().contains("Customer")) {			
			itrEntities.forEach(entity->{
				CustomerDTO dto=new CustomerDTO();
				BeanUtils.copyProperties(entity, dto);
				((ArrayList<CustomerDTO>) itrDTO).add(dto);
			});
			records=true;
		}
				
		return records?itrDTO:null;
	}

	@Override
	public void fetchRecordsByPagination(int pageSize) {
		long recordsCount=0;
		long pagesCount=0;
		Pageable pageable=null;
		Page<Customer> page=null;
		
		//find total no. of records
		recordsCount=custRepo.count();
		pagesCount=recordsCount/pageSize;
		pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
		//display records through Pagination
		for(int i=0;i<pagesCount;i++) {
			pageable=PageRequest.of(i, pageSize,Direction.DESC,"cName","cAddrs","billAmt");
			page=custRepo.findAll(pageable);
			System.out.println("=".repeat(60));
			page.getContent().forEach(System.out::println);
			System.out.println("page : "+(i+1)+" of "+page.getTotalPages());
		}		
			
	}

}
