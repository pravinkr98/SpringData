package com.ps.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmployeeInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;
	
	@Column(length = 20)
	@Type(type = "string")
	private String ename;
	
	@Column(length = 20)
	@Type(type = "string")
	private String addrs;
	
	private LocalDateTime dob;	
	private LocalDate doj;	
	private LocalTime officeTime;
}
