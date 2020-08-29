package com.ps;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.dto.CustomerDTO;
import com.ps.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj3JpaRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerMgmtService service=null;
		CustomerDTO dto=null;
		List<CustomerDTO> listDTO=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj3JpaRepoDirectMethodsApplication.class, args);
		//get bean
		service=ctx.getBean("custService", CustomerMgmtService.class);
		//prepare customer object
		dto=new CustomerDTO();
		dto.setCAddrs("Delhi");
		//dto.setCName("Rajesh");
		try {
			//invoke method
			/*listDTO=service.fetchAllRecordsByGivenExampleDTO(dto);
			
			//display records
			if(Arrays.asList(listDTO).toString().contains("Customer")) {				
				listDTO.forEach(System.out::println);
			}
			else {
				System.out.println("Records not found");
			}*/
			
			System.out.println(service.removeAllCustomers());
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
