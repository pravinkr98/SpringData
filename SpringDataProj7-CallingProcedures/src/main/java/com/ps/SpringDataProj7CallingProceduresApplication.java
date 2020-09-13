package com.ps;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.entity.Customer;
import com.ps.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj7CallingProceduresApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		EntityManager manager=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj7CallingProceduresApplication.class, args);
		//get Bean
		custRepo=ctx.getBean(CustomerRepo.class);
		//invoke methods
		try {
			//------Calling PL/SQL procedure having Entity with IN param using Entity Manager------------------------
			 manager=ctx.getBean(EntityManager.class);
			 
		 	//MySQL
			/*//Create Store ProcedureQuery object
			StoredProcedureQuery procedure=manager.createStoredProcedureQuery("GET_CUSTOMER_BY_ADDRS",Customer.class);		//
			//register procedure IN, OUT params
			procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			//set value to IN param
			procedure.setParameter(1, "Hyd");
			//call PL/SQL Procedure
			List<Customer> list=procedure.getResultList();
			list.forEach(System.out::println);
			 			
			int count=custRepo.fetchCustomersCountByAddrs("Hyd");
			System.out.println("1. Hyd customer count: "+count);
			System.out.println("-------------------------------------------------");
			System.out.println("2. Hyd customer count: "+custRepo.GET_CUSTOMERS_COUNT_BY_ADDRS("Hyd"));*/
			
			//MySQL
			/*//get EntityManager object
			//EntityManager manager1=ctx.getBean(EntityManager.class);
			//create StoredProcedureQueryObject
			StoredProcedureQuery procedure1=manager.createStoredProcedureQuery("GET_CUSTOMERS_COUNT_BY_ADDRS");
			//register params
			procedure1.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			procedure1.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
			//set value to in Params
			procedure1.setParameter(1, "Hyd");
			//get results from out param
			int count1=(int) procedure1.getOutputParameterValue(2);
			System.out.println("3. Hyd customers count :: "+count1);*/
			
			//Oracle
			//create StoredProcedureQueryObject
			StoredProcedureQuery procedure2=manager.createStoredProcedureQuery("GET_CUSTOMERS_BY_ADDRS",Customer.class);
			//register params
			procedure2.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			procedure2.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
			//set value to in params
			procedure2.setParameter(1, "Hyd");
			//get results from out param
			List<Customer> listCust=procedure2.getResultList();
			listCust.forEach(System.out::println);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close entityManager
			manager.close();
			//close container
			((ConfigurableApplicationContext) ctx).close();
		}
	}

}
