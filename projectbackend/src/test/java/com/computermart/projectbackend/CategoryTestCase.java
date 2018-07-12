package com.computermart.projectbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.computermart.projectbackend.dao.CategoryDao;
import com.computermart.projectbackend.model.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.computermart.projectbackend");
		context.refresh();
		
		categoryDAO =(CategoryDao) context.getBean("categoryDAO");
		
	}
	@Ignore
	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setCname("Desktops");
		assertEquals("success",true,categoryDAO.add(category));
		category = new Category();
		category=categoryDAO.get(1);
		category.setCname("Laptop");
		assertEquals("success",true,categoryDAO.add(category));
	}
	
	@Ignore
	@Test
	public void testGetCategory() {
		category=categoryDAO.get(1);
		assertEquals("success","Desktops",category.getCname());
		
	}
	
	@Ignore
	@Test
	public void testDeleteCategory() {
		
		assertEquals("success",true,categoryDAO.delete(2));
	}
	
	
}
