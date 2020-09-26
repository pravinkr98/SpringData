package com.ps.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class UserDTO implements Serializable {

	private Integer userId;
	private String name;
	private String addrs;
	private Set<PhoneNumberDTO> phones;

}
