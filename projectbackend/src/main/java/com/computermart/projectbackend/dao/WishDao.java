package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.Wish;


public interface WishDao {
	
	boolean add(Wish wish);
	boolean delete(int id);
	Wish get(int id);
	List<Wish> show(int cartId);

}
