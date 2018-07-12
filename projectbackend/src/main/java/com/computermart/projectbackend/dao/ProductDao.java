package com.computermart.projectbackend.dao;

import java.util.List;

import com.computermart.projectbackend.model.Category;
import com.computermart.projectbackend.model.Product;

public interface ProductDao {
	Product saveOrUpdateProduct(Product product); 
	   Product getProduct(int id);
	   void deleteProduct(int id);
	   List<Product> getAllProducts();
	   public List<Product> getCategoryProducts(int cid);
}
