package com.ps;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.dto.PhoneNumberDTO;
import com.ps.dto.UserDTO;
import com.ps.service.TelecomeMgmtService;

@SpringBootApplication
public class SpringDataProj10AssociationMappingOneToManyUniApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TelecomeMgmtService service=null;
		PhoneNumberDTO phone1=null,phone2=null;
		UserDTO userDTO=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj10AssociationMappingOneToManyUniApplication.class, args);
		//get service bean
		service=ctx.getBean("tmService", TelecomeMgmtService.class);
		//prepare phone1 object
				phone1=new PhoneNumberDTO();
				phone1.setMobileNo(7777777777L);
				phone1.setProvider("Airtel");
				phone1.setType("Residence");
		//prepare phone2 object
				phone2=new PhoneNumberDTO();
				phone2.setMobileNo(6666666666L);
				phone2.setProvider("Idea");
				phone2.setType("Office");
		//prepare user object
			userDTO=new UserDTO();
			userDTO.setName("Mukesh");
			userDTO.setAddrs("Hyd");
			userDTO.setPhones(Set.of(phone1,phone2));	// Java9 feature
		//invoke method to save
			try {
				System.out.println(service.registerCustomer(userDTO));
			}
			catch (Exception e) {
				System.out.println("Problem in Customer registration");
				e.printStackTrace();
			}
			//close container
			((ConfigurableApplicationContext) ctx).close();
	}

}//class