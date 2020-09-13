package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.service.CustomerService;

@SpringBootApplication
public class SpringDataProj7CallingFunction {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerService service=null;
				
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj7CallingFunction.class, args);
		//get bean
		service=ctx.getBean("empService", CustomerService.class);
		//invoke method
		service.getEmployeeDetails(2675);
						
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class