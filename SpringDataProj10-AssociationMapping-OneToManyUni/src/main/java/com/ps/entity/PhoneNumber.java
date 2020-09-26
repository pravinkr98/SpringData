package com.ps.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DATA_PHONE_NUMBER")
@Getter
@Setter
public class PhoneNumber implements Serializable {

	@Id
	@Type(type = "long")
	private  Long mobileNo;
	
	@Column(length = 15)
	@Type(type = "string")
	private String provider;

	@Column(length = 15)
	@Type(type = "string")
	private String type;
	
}
