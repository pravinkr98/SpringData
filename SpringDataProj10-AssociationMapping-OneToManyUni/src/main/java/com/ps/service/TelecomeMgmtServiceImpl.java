package com.ps.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dto.PhoneNumberDTO;
import com.ps.dto.UserDTO;
import com.ps.entity.PhoneNumber;
import com.ps.entity.User;
import com.ps.repo.UserRepo;

@Service("tmService")
public class TelecomeMgmtServiceImpl implements TelecomeMgmtService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String registerCustomer(UserDTO userDTO) {
		User userEntity =null;
		Set<PhoneNumber> phoneEntity=new HashSet<>();
		Set<PhoneNumberDTO> phoneDTO=null;
		
		//convert dto to entity
		userEntity=new User();
		userEntity.setName(userDTO.getName());
		userEntity.setAddrs(userDTO.getAddrs());
		phoneDTO=userDTO.getPhones();
		phoneDTO.forEach(pDTO->{
			PhoneNumber pEntity=new PhoneNumber();
			BeanUtils.copyProperties(pDTO, pEntity);
			phoneEntity.add(pEntity);
		});
		userEntity.setPhones(phoneEntity);
		
		//use Repo
		return "Customer saved having id :: "+userRepo.save(userEntity).getUserId();
	}

}
