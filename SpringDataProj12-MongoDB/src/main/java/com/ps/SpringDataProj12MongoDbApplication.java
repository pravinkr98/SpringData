package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.document.Employee;
import com.ps.service.EmployeeMgmtService;

@SpringBootApplication
public class SpringDataProj12MongoDbApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		Employee doc1=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj12MongoDbApplication.class, args);
		//get Service class object
		service=ctx.getBean("empService", EmployeeMgmtService.class);
		try {
			/*doc1=new Employee();
			doc1.setEid(458);
			doc1.setEname("Vikash");
			doc1.setEadd("pune");
			doc1.setSalary(93000.0f);
			doc1.setCompany("HCL");
			doc1.setOldCompanies(new String[] {"Oracle","Infosys"});
			System.out.println(service.registerEmployee(doc1));*/
			
			service.findAllEmployees().forEach(System.out::println);
			//System.out.println(service.findEmpById(458));
			//System.out.println(service.updateEmpSalary(456, 3000.0f));
			//System.out.println(service.removeEmployee(456));
		}
		catch (Exception e) {
			System.out.println("Problem in registration");
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}
}
