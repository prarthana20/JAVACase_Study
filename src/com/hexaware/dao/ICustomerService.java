package com.hexaware.dao;

import com.hexaware.entity.Customer;
import com.hexaware.exception.*;

public interface ICustomerService {
	

	Customer getCustomerByUsername(String customerUsername) throws CustomerNotFoundException;

	boolean registerCustomer(Customer customer);

	boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
	
	Customer getCustomerById(int customerId) throws CustomerNotFoundException;

	boolean updateCustomer(Customer customer) throws CustomerNotFoundException;

	
	
	
}