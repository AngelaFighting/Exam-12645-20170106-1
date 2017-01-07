package testService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CustomerService;

public class TestCustomerService {

	public static void main(String args[]){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = 
				(CustomerService) applicationContext.getBean("customerService");
		
		System.out.println("admin:"+customerService.selectCustomer("admin"));//null
		//mary:Customer [customerId=1, firstName=MARY, lastName=SMITH]
		System.out.println("mary:"+customerService.selectCustomer("mary"));
	}
}
