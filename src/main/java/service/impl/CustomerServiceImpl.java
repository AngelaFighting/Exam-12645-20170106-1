package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerMapper;
import model.Customer;
import service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Customer selectCustomer(String name) {
		return customerMapper.selectCustomerByFirstName(name);
	}

}
