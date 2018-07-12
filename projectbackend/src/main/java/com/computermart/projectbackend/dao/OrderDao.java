package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.CustomerOrder;

public interface OrderDao {

	boolean insert(CustomerOrder order);
	
	List<CustomerOrder> viewAllOrder(int cartId);
	
	List<CustomerOrder> viewreceipt(String orderid);
	
	 
}
