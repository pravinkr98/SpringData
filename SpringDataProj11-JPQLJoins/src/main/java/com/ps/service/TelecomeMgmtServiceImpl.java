package com.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.repo.UserRepo;

@Service("tmService")
public class TelecomeMgmtServiceImpl implements TelecomeMgmtService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<Object[]> getDataByJoins() {
		//use repo		
		return userRepo.fetchDataByJoins();
	}

	@Override
	public List<Object[]> getDataByJoinsAddrs(String addr) {
		// use repo
		return userRepo.fetchDataByJoinsAddrs(addr);
	}
	
	
}
