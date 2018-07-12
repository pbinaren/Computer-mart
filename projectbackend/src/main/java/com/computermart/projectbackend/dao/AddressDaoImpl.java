package com.computermart.projectbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computermart.projectbackend.model.Cart;
import com.computermart.projectbackend.model.ShipAddress;

@Repository("addressDAO")
@Transactional
public class AddressDaoImpl implements AddressDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	private static List<ShipAddress> addresslist = new ArrayList<>();
	
	ShipAddress address = new ShipAddress();
	
	@Override
	public boolean add(ShipAddress shipAddress) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(shipAddress);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;	
		}

	}

	@Override
	public boolean delete(int id) {
		try {
			address = sessionFactory.getCurrentSession().get(ShipAddress.class, id);
			sessionFactory.getCurrentSession().delete(address);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;	
		}

	}

	@Override
	public ShipAddress show(int id) {
		address = sessionFactory.getCurrentSession().get(ShipAddress.class, id);
		return address;
	}

	@Override
	public List<ShipAddress> list(int cartId) {
		try {
			addresslist = (List<ShipAddress>) sessionFactory.getCurrentSession().createQuery("from ShipAddress where cartId="+cartId).list();
			return addresslist;
		} catch (Exception e) {
			return null;
		}
	}

}
