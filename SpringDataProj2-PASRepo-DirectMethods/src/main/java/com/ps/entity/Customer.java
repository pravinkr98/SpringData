package com.ps.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Customer implements Serializable {

	@Id
	@Type(type = "int")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cNo;
	
	@Column(name="CNAME",length = 25)
	@Type(type = "string")
	private String cName;
	
	@Column(name = "CADDRS",length = 30)
	@Type(type = "string")
	private String cAddrs;
	
	@Column(name = "BILLAMT")
	@Type(type = "double")
	private double billAmt;
}
