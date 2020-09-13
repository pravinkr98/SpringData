package com.ps;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.repo.CustomerRepo;
import com.ps.repo.CustomerRepo.ResultsView1;
import com.ps.repo.CustomerRepo.ResultsView2;
import com.ps.repo.CustomerRepo.View;

@SpringBootApplication
public class SpringDataProj5JpaRepoFinderMethodsScalarQueriesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		
		//get container
		ctx=SpringApplication.run(SpringDataProj5JpaRepoFinderMethodsScalarQueriesApplication.class, args);
		//get bean
		custRepo=ctx.getBean(CustomerRepo.class);
		//invoke method
		/*List<ResultsView1> view1=custRepo.findByCAddrs("Hyd");
		for(ResultsView1 v: view1) {
			System.out.println(v.getcNo()+"     "+v.getCName()+"    "+v.getClass());
		}*/
		
		//List<ResultsView2> view2=custRepo.findBycNoBetween(65, 70);
		/*for(ResultsView2 v: view2) {
			System.out.println(v.getCName()+"    "+v.getBillAmt());
		}*/
		//view2.forEach(v->System.out.println(v.getCName()+"    "+v.getBillAmt()));
		
		/*List<ResultsView1> listView1=custRepo.findByCAddrs("Hyd", ResultsView1.class);
		for(ResultsView1 v: listView1) {
			System.out.println(v.getcNo()+"    "+v.getCName());
		}	*/	
		
		System.out.println("--------------------------------------------------------------------");
		List<ResultsView2> listView2=custRepo.findByCAddrs("Hyd", ResultsView2.class);
		for(ResultsView2 v: listView2) {
			System.out.println(v.getCName()+"    "+v.getBillAmt());
		}	
		
		/*List<ResultsView1> listView=custRepo.findByCAddrs("Delhi", ResultsView1.class);
		for(ResultsView1 v:listView) {
			System.out.println(v.getcNo()+"    "+v.getCName());
		}*/
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
