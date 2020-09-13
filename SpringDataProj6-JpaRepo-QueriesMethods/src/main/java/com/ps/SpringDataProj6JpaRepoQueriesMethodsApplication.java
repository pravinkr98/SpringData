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
public class SpringDataProj6JpaRepoQueriesMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		EntityManager manager=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj6JpaRepoQueriesMethodsApplication.class, args);
		//get Bean
		custRepo=ctx.getBean(CustomerRepo.class);
		//invoke methods
		try {
			//custRepo.getAllCustomers().forEach(System.out::println);
			//custRepo.getCustomersByCity("Hyd").forEach(System.out::println);
			//custRepo.getCustomersByBillAmtRange(30000, 70000).forEach(System.out::println);
			//custRepo.getCustomersByCityNames("Hyd", "Delhi", "Patna").forEach(System.out::println);
			//custRepo.getCustomersByName("Raja").forEach(System.out::println);
			//custRepo.getCustomersByCnoRange(65, 70).forEach(System.out::println);
			/*custRepo.getCustomersValuesByCity("Delhi").forEach(row->{
				System.out.println(row[0]+"     "+row[1]);
			});*/
			//custRepo.getBillAmtByCities("Hyd", "Delhi").forEach(System.out::println);			
			//System.out.println(custRepo.getCustomerByName("Raja"));
			/*Object obj=custRepo.getCustomerValuesByName("Raja");
			Object ob[]=(Object[]) obj;
			System.out.println(ob[0]+"     "+ob[1]);*/
			//System.out.println("Bill Amount :: "+custRepo.getCustomerBillAmtByName("Raja"));
			//System.out.println("Max bill amount is :: "+custRepo.getMaxBillAmount());
			/*Object data[]=(Object[])custRepo.findAggregateResults();
			System.out.println("Max bill amount :: "+data[0]);
			System.out.println("Sum of bill amounts :: "+data[1]);
			System.out.println("Average of bill amounts :: "+data[2]);
			System.out.println("Total numbers of Customer :: "+data[3]);*/
			
			//------------------------- Non Select operations-----------------------------
			//System.out.println("No. of records updated :: "+custRepo.modifyCustomerBillAmtByCity("Delhi", 3300));
			//System.out.println("No. of records deleted :: "+custRepo.deleteCustomerByCAddrsIfNull());
			//custRepo.getCustomersByAddrs("Hyd").forEach(System.out::println);
			//System.out.println("System Date is :: "+custRepo.getSysDate());
			//System.out.println("No. of Record inserted : "+custRepo.insertCustomerRecord(45000.45, "Hyd", "Guddu"));
			//custRepo.fetchCustomerDataByAddrs("Hyd").forEach(System.out::println);
			
			//------Calling PL/SQL procedure having Entity with IN param using Entity Manager------------------------
			 manager=ctx.getBean(EntityManager.class);
			//Create Store ProcedureQuery object
			StoredProcedureQuery procedure=manager.createStoredProcedureQuery("GET_CUSTOMER_BY_ADDRS",Customer.class);		//
			//register procedure IN, OUT params
			procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			//set value to IN param
			procedure.setParameter(1, "Hyd");
			//call PL/SQL Procedure
			List<Customer> list=procedure.getResultList();
			list.forEach(System.out::println);
			
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
