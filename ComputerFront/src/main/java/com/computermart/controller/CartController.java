package com.computermart.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.computermart.projectbackend.dao.CartDao;
import com.computermart.projectbackend.dao.CategoryDao;
import com.computermart.projectbackend.dao.ProductDao;
import com.computermart.projectbackend.model.Cart;
import com.computermart.projectbackend.model.Product;

@Controller
public class CartController
{

	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDAO;
	@Autowired
	private CartDao cartDAO;
	
	
	



	@RequestMapping(value = "cart/addprod/{id}")
	public String addcart(@PathVariable int id,@RequestParam(value="qnty") int qnty, Model model, HttpSession session) 
	{
		ArrayList<Cart> cartlist = (ArrayList<Cart>) cartDAO
				.show(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Product product = productDAO.getProduct(id);	
		
if(product.getQuantity()>=qnty) {
		
		for(Cart cartItem:cartlist){
			if(cartItem.getPid()==id)
			{
				
				cartItem.setQty(qnty);
				cartItem.setTotal(qnty*product.getPrice());
				cartDAO.add(cartItem);
				return "redirect:/cart/viewcart";
			}
		}
		
		Cart cart = new Cart();
		cart.setCartId(Integer.parseInt(session.getAttribute("usercartid").toString()));
		cart.setPid(product.getId());
		cart.setPname(product.getName());
		cart.setQty(qnty);
		cart.setPprice(product.getPrice());
		cart.setTotal(product.getPrice());
		cartDAO.add(cart);
		return "redirect:/cart/viewcart";
} else
{
	model.addAttribute("msg", true);
	model.addAttribute("productlist", productDAO.getAllProducts());
	model.addAttribute("product", productDAO.getProduct(id));
	model.addAttribute("title", "Product Info"); 	
	model.addAttribute("userClickProductInfo", true);
	model.addAttribute("categorylist", categoryDAO.list());
	return "page";
}

	}

	
	@RequestMapping(value = "cart/viewcart")
	public String viewcart(Model model, HttpSession session) 
	{
		ArrayList<Cart> cartlist = (ArrayList<Cart>) cartDAO
				.show(Integer.parseInt(session.getAttribute("usercartid").toString()));
		model.addAttribute("title", "Cart");
		model.addAttribute("cartlist", cartlist);
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickCart", true);
		model.addAttribute("msg", false);
		session.setAttribute("cartsize", cartlist.size());
		return "page";

	}

	@RequestMapping(value = "deletecart/{id}")
	public String delcart(@PathVariable int id, Model model) {
			cartDAO.delete(id);
			return "redirect:/cart/viewcart";
	}
	
		

		
}
