package com.ps.service;

import java.util.List;

public interface TelecomeMgmtService {

	List<Object[]> getDataByJoins();
	List<Object[]> getDataByJoinsAddrs(String addr);
}
