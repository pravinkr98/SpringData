package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ps.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj4JpaRepoFinderMethodsEntityQueriesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringDataProj4JpaRepoFinderMethodsEntityQueriesApplication.class, args);
		//get bean
		custRepo=ctx.getBean(CustomerRepo.class);
		
		//invoke methods
		//custRepo.findBycAddrs("Hyd").forEach(System.out::println);
		//custRepo.findBycName("Ramesh").forEach(System.out::println);
		//custRepo.findBybillAmtGreaterThan(50000).forEach(System.out::println);
		//custRepo.findBybillAmtLessThan(50000).forEach(System.out::println);
		//custRepo.findBycNameLike("Ram%").forEach(System.out::println);
		//custRepo.findBycNameStartingWith("R").forEach(System.out::println);
		//custRepo.findBycNameEndingWith("h").forEach(System.out::println);
		//custRepo.findBycNameContaining("m").forEach(System.out::println);		
		//custRepo.findBycAddrsIsNull().forEach(System.out::println);
		//custRepo.findBycAddrsIsNotNull().forEach(System.out::println);
		custRepo.findBycAddrsNotNull().forEach(System.out::println);
		
	}

}
