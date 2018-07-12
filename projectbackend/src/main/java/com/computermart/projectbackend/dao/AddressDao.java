package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.ShipAddress;

public interface AddressDao {
	
	boolean add(ShipAddress shipAddress);
	boolean delete(int id);
	ShipAddress show(int id);
	List<ShipAddress> list(int cartId);
}
