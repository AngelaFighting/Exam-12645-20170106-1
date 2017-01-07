package dao;

import model.Customer;

public interface CustomerMapper {

	public Customer selectCustomerByFirstName(String name);
	
}
