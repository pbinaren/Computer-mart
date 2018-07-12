package com.computermart.projectbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computermart.projectbackend.model.Cart;
import com.computermart.projectbackend.model.Wish;

@Repository("wishDAO")
@Transactional
public class WishDaoImpl implements WishDao {

	@Autowired
	SessionFactory sessionFactory;

	private static List<Wish> wishlist = new ArrayList<>();
	
	Wish wish= new Wish();
	
	@Override
	public boolean add(Wish wish) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(wish);
		
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
			
			wish = sessionFactory.getCurrentSession().get(Wish.class, id);
			sessionFactory.getCurrentSession().delete(wish);
		
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();

			return false;	
		}

	}

	@Override
	public Wish get(int id) {
		wish = sessionFactory.getCurrentSession().get(Wish.class, id);
		return wish;
	}

	@Override
	public List<Wish> show(int cartId) {
		try {
			wishlist = (List<Wish>) sessionFactory.getCurrentSession().createQuery("from Wish where cartId="+cartId).list();
			return wishlist;
		} catch (Exception e) {
			return null;
		}
	}

}
