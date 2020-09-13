package com.ps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
		dto.setDob(LocalDateTime.of(1986,10,24,3,27,30));
		dto.setDoj(LocalDate.of(2018, 8, 16));
		dto.setOfficeTime(LocalTime.now());
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
