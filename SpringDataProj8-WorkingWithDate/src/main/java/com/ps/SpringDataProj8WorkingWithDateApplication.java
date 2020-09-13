package com.ps;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.dto.EmployeeInfoDTO;
import com.ps.service.EmployeeInfoMgmtService;

@SpringBootApplication
public class SpringDataProj8WorkingWithDateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeInfoMgmtService service=null;
		EmployeeInfoDTO dto=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj8WorkingWithDateApplication.class, args);
		//get bean
		service=ctx.getBean("empService", EmployeeInfoMgmtService.class);
		/*//prepare employee object
		dto=new EmployeeInfoDTO();
		dto.setEname("Ganesh");
		dto.setAddrs("Muz");
		dto.setDob(new Date(84,8,23,03,10,28));
		dto.setDoj(new Date(108,11,12));
		dto.setOfficeTime(new Date());
		//invoke method
		try {
			System.out.println("New Employee id :: "+service.registerEmployee(dto));
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		service.fetchAllEmployeeInfo().forEach(System.out::println);		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
