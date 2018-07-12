package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.Customer;
import com.computermart.projectbackend.model.UserCredentials;

public interface CustomerDao {
	
	public boolean addCustomer(Customer customer);
	public boolean delCustomer(String emailId);
	public Customer showCustomer(String emailId);
	public List<Customer> showAllCustomer();
	public UserCredentials showcred(String email);
	public boolean saveorupdatepassword(UserCredentials uc);

}
