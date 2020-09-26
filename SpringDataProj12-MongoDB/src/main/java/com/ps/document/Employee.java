package com.ps.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Employee {

	@Id
	private Integer eid;
	private String ename;
	private String eadd;
	private String company;
	private Float salary;
	private String[] oldCompanies;
}
