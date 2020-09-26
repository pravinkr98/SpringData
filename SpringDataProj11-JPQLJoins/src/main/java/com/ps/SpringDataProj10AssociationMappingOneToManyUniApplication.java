package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.service.TelecomeMgmtService;

@SpringBootApplication
public class SpringDataProj10AssociationMappingOneToManyUniApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TelecomeMgmtService service=null;
				
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj10AssociationMappingOneToManyUniApplication.class, args);
		//get service bean
		service=ctx.getBean("tmService", TelecomeMgmtService.class);
		//invoke method to save
			try {
				/*service.getDataByJoins().forEach(row->{
					for(Object val:row) 
						System.out.print(val+"  ");
					System.out.println();
				});*/
			
				service.getDataByJoinsAddrs("Patna").forEach(row->{
					for(Object val:row) 
						System.out.print(val+"  ");
					System.out.println();
				});
			}
			catch (Exception e) {
				System.out.println("Problem in Customer registration");
				e.printStackTrace();
			}
			//close container
			((ConfigurableApplicationContext) ctx).close();
	}

}//class