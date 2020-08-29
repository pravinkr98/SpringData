package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.ps.dto.CustomerDTO;
import com.ps.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj2PasRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerMgmtService service=null;
		Iterable<CustomerDTO> iDTO=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj2PasRepoDirectMethodsApplication.class, args);
		//get bean
		service=ctx.getBean("custService", CustomerMgmtService.class);
		
		//invole method
		try {
			//iDTO=service.fetchAllRecordsSortByProperty("cName", true);
			//iDTO=service.fetchAllRecordsSortByProperty(false, "cName","cAddrs","billAmt");
			//iDTO=service.fetchRecordsByPageNoAndSize(1,4);
			
			/*if(iDTO==null) {
				System.out.println("No records found to display");
			}
			else {
				System.out.println("=".repeat(60));
				iDTO.forEach(System.out::println);
				System.out.println("=".repeat(60));
			}	*/		
			
			service.fetchRecordsByPagination(4);
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
