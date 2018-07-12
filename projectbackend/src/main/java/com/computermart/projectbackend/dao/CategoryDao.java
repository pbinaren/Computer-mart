package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.Category;

public interface CategoryDao {
	
	
	boolean add(Category category);
	List<Category> list();
	Category get(int id);

	boolean delete(int id);

}
