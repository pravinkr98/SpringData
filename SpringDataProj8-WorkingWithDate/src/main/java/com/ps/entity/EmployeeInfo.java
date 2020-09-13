package com.ps.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	@Temporal(TemporalType.DATE)
	private Date doj;
	
	@Temporal(TemporalType.TIME)		//Oracle does not support Time
	//@Temporal(TemporalType.DATE)
	private Date officeTime;
}
