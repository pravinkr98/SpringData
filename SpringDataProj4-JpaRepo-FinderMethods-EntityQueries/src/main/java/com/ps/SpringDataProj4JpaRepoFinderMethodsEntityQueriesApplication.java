package com.ps;

import java.util.List;

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
		//custRepo.findByCAddrs("Hyd").forEach(System.out::println);
		//custRepo.findByCName("Ramesh").forEach(System.out::println);
		//custRepo.findBybillAmtGreaterThan(50000).forEach(System.out::println);
		//custRepo.findBybillAmtLessThan(50000).forEach(System.out::println);
		//custRepo.findByCNameLike("Ram%").forEach(System.out::println);
		//custRepo.findByCNameLike("____").forEach(System.out::println);
		//custRepo.findByCNameLike("_____%").forEach(System.out::println);
		//custRepo.findByCNameStartingWith("R").forEach(System.out::println);
		//custRepo.findByCNameEndingWith("h").forEach(System.out::println);
		//custRepo.findByCNameContaining("m").forEach(System.out::println);		
		//custRepo.findByCAddrsIsNull().forEach(System.out::println);
		//custRepo.findByCAddrsIsNotNull().forEach(System.out::println);
		//custRepo.findByCAddrsNotNull().forEach(System.out::println);
		//NotWorking-->//custRepo.findBybillAmtGreaterThanEqualAndbillAmtLessThanEqual(40000.0, 70000.0).forEach(System.out::println);
		//custRepo.findBybillAmtBetween(40000, 70000).forEach(System.out::println);
		//custRepo.findByCNameEqualsOrCAddrsEquals("Raja", "Hyd").forEach(System.out::println);
		//custRepo.findByCNameOrCAddrs("Raja", "Hyd").forEach(System.out::println);
		//custRepo.findByBillAmtBetweenOrderByCNameDesc(40000, 80000).forEach(System.out::println);
		//custRepo.findByCAddrsNot("Hyd").forEach(System.out::println);
		custRepo.findByCAddrsIn(List.of("Hyd","Vizag","Delhi")).forEach(System.out::println);
		
	}

}
