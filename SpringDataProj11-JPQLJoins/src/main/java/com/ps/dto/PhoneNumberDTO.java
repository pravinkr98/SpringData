package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneNumberDTO implements Serializable {

	private  Long mobileNo;
	private String provider;
	private String type;
	
}
