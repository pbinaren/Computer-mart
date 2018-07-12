package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.Cart;
import com.computermart.projectbackend.model.Category;

public interface CartDao {

	boolean add(Cart cart);
	boolean delete(int id);
	Cart get(int id);
	List<Cart> show(int cartId);
	
}
