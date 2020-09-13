package com.ps.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("empService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private EntityManager manager;
	
	@Override
	public void getEmployeeDetails(int eno) {
		
		//get Session object
		Session ses=manager.unwrap(Session.class);
		Double salary=ses.doReturningWork(new ReturningWork<Double>() {

			@Override
			public Double execute(Connection con) throws SQLException {
				//create CallableStatement obj
				CallableStatement cs=con.prepareCall("{?=call FX_GET_EMP_DETAILS_BY_JOB(?,?,?,?)}");
				//register Return,OUT params with JDBC types
				cs.registerOutParameter(1, java.sql.Types.DOUBLE);
				cs.registerOutParameter(3, java.sql.Types.VARCHAR);
				cs.registerOutParameter(4, java.sql.Types.VARCHAR);
				cs.registerOutParameter(5, java.sql.Types.VARCHAR);
				//set value to IN param
				cs.setInt(2, eno);
				//call PL/SQL function
				cs.execute();
				//gather results from OUT params and RETURN param
				System.out.println("EMp name :: "+cs.getString(4));
				System.out.println("Emp desg.:: "+cs.getString(3));
				System.out.println("Emp address :: "+cs.getString(5));					
				return cs.getDouble(1);
			}//execute(-)				
		}//anonymous inner class
		);//method call
			System.out.println("Emp salary :: "+salary);
			System.out.println("Emp no :: "+eno);
		
		//close entityManager
		manager.close();
		
	}//method
}//class