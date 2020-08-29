package com.ps;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.dto.CustomerDTO;
import com.ps.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj1CurdRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerMgmtService services=null;
		CustomerDTO customer=null,customer1=null,customer2=null,customer3=null;
		//List<CustomerDTO> listDTO=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj1CurdRepoDirectMethodsApplication.class, args);
		//get service class bean obj
		services=ctx.getBean("custService", CustomerMgmtService.class);
		//fill Customer details
		customer=new CustomerDTO();
		customer.setCName("Maharaja");customer.setCAddrs("Hyd");customer.setBillAmt(50000.0);
		customer1=new CustomerDTO();
		customer1.setCName("Mahesh");customer1.setCAddrs("Delhi");customer1.setBillAmt(40000.0);
		customer2=new CustomerDTO();
		customer2.setCName("Suresh");customer2.setCAddrs("Mumbai");customer2.setBillAmt(63000.0);
		customer3=new CustomerDTO();
		customer3.setCName("Ramesh");customer3.setCAddrs("Pune");customer3.setBillAmt(49000.0);
		//add customer into list
		//save customer
		try {
			//System.out.println(services.registerCustomer(custo));
			
			/*	listDTO=new ArrayList<>();
			listDTO.add(customer);listDTO.add(customer1);	listDTO.add(customer2);listDTO.add(customer3);*/
			//System.out.println(services.registerGroupCustomers(listDTO));
			
			//System.out.println(services.registerGroupCustomers(Arrays.asList(customer,customer1,customer2,customer3)));
			
			//System.out.println(services.registerGroupCustomers(List.of(customer, customer1, customer2, customer3)));	//from Java9
			
			//System.out.println(services.removeCustomerById(40));
			
			//System.out.println(services.removeGivenCustomers(List.of(new CustomerDTO(62),new CustomerDTO(63))));
			
			//System.out.println(services.fetchCustomerCount());
			
			//System.out.println("=".repeat(60));
			//System.out.println(services.fetchAllCustomers()); 			//old approach
			//services.fetchAllCustomers().forEach(System.out::println);		//Java8 method reference
			/*services.fetchAllCustomers().forEach(e->{			//Java forEach
				System.out.println(e);
			});*/
			//System.out.println("=".repeat(60));
			
			try {
				Optional<CustomerDTO> dto=services.fetchCustomerById(65);
				if(dto.isPresent()) {
					System.out.println(dto.get());
				}
				else {
					System.out.println("record not found");
				}
			}
			catch (DataAccessException dae) {
				dae.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			((ConfigurableApplicationContext) ctx).close();
		}
		
	}

}
