package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Customer;
import service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;	
	
	@RequestMapping("/login")
	public boolean login(@RequestParam("name") String name,
			HttpSession session){
		Customer customer=customerService.selectCustomer(name);
		if(customer!=null){
			session.setAttribute("customer",customer);
			return true;
		}else
			return false;
	}
	
	@RequestMapping("logout")
	public void logout(Map<String, Object> map){
		map.remove("customer");
	}
}
