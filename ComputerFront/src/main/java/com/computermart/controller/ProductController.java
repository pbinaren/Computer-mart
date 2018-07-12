package com.computermart.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.computermart.projectbackend.dao.CategoryDao;
import com.computermart.projectbackend.dao.ProductDao;
import com.computermart.projectbackend.model.Category;
import com.computermart.projectbackend.model.Product;

@Controller
public class ProductController {
	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDAO;
	


	@RequestMapping(value = "admin/categories")
	public String manageCategory(Model model) {
		model.addAttribute("title", "Manage Category");
		model.addAttribute("edit", false);
		model.addAttribute("userClickManageCategory", true);
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("category", new Category());
		model.addAttribute("status", false);
		return "page";
	}

	@RequestMapping(value = "admin/setcategory")
	public String setCategory(@Valid @ModelAttribute("category") Category category,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Manage Category");
			model.addAttribute("userClickManageCategory", true);
			model.addAttribute("categorylist", categoryDAO.list());
			model.addAttribute("category", new Category());
			model.addAttribute("status", true);
			model.addAttribute("edit", false);
			return "page";
		}

		try {
			categoryDAO.add(category);
			return "redirect:/admin/categories";
		} catch (Exception e) {
			model.addAttribute("title", "Manage Category");
			model.addAttribute("userClickManageCategory", true);
			model.addAttribute("categorylist", categoryDAO.list());
			model.addAttribute("category", new Category());
			model.addAttribute("status", true);
			model.addAttribute("edit", false);
			return "page";
		}

	}
	
	@RequestMapping(value = "admin/delcat/{cid}")
	public String delcat(@PathVariable int cid, Model M) {
		try {
			categoryDAO.delete(cid);
			return "redirect:/admin/categories";
		} catch (Exception e) {
			M.addAttribute("categorylist", categoryDAO.list());
			M.addAttribute("status", true);
			M.addAttribute("edit", false);
			M.addAttribute("category", new Category());
			M.addAttribute("title", "Category");
			M.addAttribute("userClickManageCategory", true);
			return "page";
		}
	}
	
	@RequestMapping(value = "admin/editcat/{cid}")
	public String showcategory(@PathVariable int cid, Category category, Model M ) {
		
		M.addAttribute("categorylist", categoryDAO.list());
		M.addAttribute("status", false);
		M.addAttribute("edit", true);
		M.addAttribute("category", categoryDAO.get(cid));
		M.addAttribute("title", "Category");
		M.addAttribute("userClickManageCategory", true);
		return "page";
		
	}


	@RequestMapping(value = "admin/products")
	public String manageProducts(Model model) {
		model.addAttribute("title", "Manage Products");
		model.addAttribute("userClickManageProducts", true);
		model.addAttribute("productlist", productDAO.getAllProducts());
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("product", new Product());
		model.addAttribute("status", false);
		model.addAttribute("edit", false);
		return "page";
	}

	@RequestMapping(value = "admin/setproduct")
	public String setProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model)
	{
		if (result.hasErrors()) 
		{
			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("categorylist", categoryDAO.list());
			model.addAttribute("product", product);
			model.addAttribute("status", true);
			model.addAttribute("edit", false);
			model.addAttribute("productlist", productDAO.getAllProducts());
			return "page";
		} 
		else 
		{
			try 
			{
				productDAO.saveOrUpdateProduct(product);
				uploadfile(product.getId(),product.getImage());
				return "redirect:/admin/products";
			}

			catch (Exception e) {	
			 model.addAttribute("title", "Manage Products");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("categorylist", categoryDAO.list());
			model.addAttribute("product", product);
			model.addAttribute("status", true);
			model.addAttribute("edit", false);
			model.addAttribute("productlist", productDAO.getAllProducts());
				return "page";
			}
		}	
		
	}
	
	@RequestMapping(value = "admin/delprod/{id}")
	public String delprod(@PathVariable int id, Model model) {
		try {
			productDAO.deleteProduct(id);
			String path="E:\\niit\\project\\Demo\\ComputerFront\\src\\main\\webapp\\resources\\productimages\\";
			path=path+String.valueOf(id+".jpg");
			Path paths= Paths.get(path);
			if(Files.exists(paths)){
				try {
					Files.delete(paths);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return "redirect:/admin/products";
		} catch (Exception e) {
			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("productlist", productDAO.getAllProducts());
			model.addAttribute("categorylist", categoryDAO.list());
			model.addAttribute("product", new Product());
			model.addAttribute("status", false);
			model.addAttribute("edit", false);
			return "page";
		}
	}
	
	@RequestMapping(value = "admin/editprod/{id}")
	public String editProduct(@PathVariable int id, Product product, Model M ) {
		
		M.addAttribute("productlist", productDAO.getAllProducts());
		M.addAttribute("status", false);
		M.addAttribute("edit", true);
		M.addAttribute("product", productDAO.getProduct(id));
		M.addAttribute("title", "Edit Product");
		M.addAttribute("userClickManageProducts", true);
		M.addAttribute("categorylist", categoryDAO.list());
		return "page";
		
	}
	
	@RequestMapping(value = "info/{id}")
	public String productInfo(@PathVariable int id, Product product, Model M ) {
		M.addAttribute("msg", false);
		M.addAttribute("productlist", productDAO.getAllProducts());
		M.addAttribute("product", productDAO.getProduct(id));
		M.addAttribute("title", "Product Info"); 	
		M.addAttribute("userClickProductInfo", true);
		M.addAttribute("categorylist", categoryDAO.list());
		return "page";
		
	}
	
	void uploadfile(int id,MultipartFile f) throws Exception
	{
		String path="E:\\niit\\project\\Demo\\ComputerFront\\src\\main\\webapp\\resources\\productimages\\";
		path=path+String.valueOf(id+".jpg");
		if(!f.isEmpty())
		{
			byte[] b=f.getBytes();
			BufferedOutputStream bs=new  BufferedOutputStream(new FileOutputStream(new File(path)));
			bs.write(b);
			bs.close();
			Thread.sleep(10000);
		}
	}
}
