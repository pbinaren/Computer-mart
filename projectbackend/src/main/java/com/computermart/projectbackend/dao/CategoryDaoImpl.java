package com.computermart.projectbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computermart.projectbackend.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	Category category =new Category();
	
	@Override
	public List<Category> list() {
		try {
			categories = (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category").list();
			return categories;
		} catch (Exception e) {
			return null;
		}
		
	}
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class , Integer.valueOf(id)  );
	}
	@Override
	
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		
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
			sessionFactory.getCurrentSession().delete(get(id));
		
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();

			return false;	
		}

	}

}
