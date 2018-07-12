package com.computermart.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computermart.projectbackend.dao.CategoryDao;
import com.computermart.projectbackend.dao.ProductDao;
import com.computermart.projectbackend.dao.WishDao;
import com.computermart.projectbackend.model.Product;
import com.computermart.projectbackend.model.Wish;

@Controller
public class WishlistController {

	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDAO;
	@Autowired
	private WishDao wishDAO;
	
	@RequestMapping(value = "cart/addwish/{id}")
	public String addwish(@PathVariable int id, Model model, HttpSession session) 
	{
		ArrayList<Wish> wishlist = (ArrayList<Wish>) wishDAO
				.show(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Product product = productDAO.getProduct(id);	
		for(Wish wish: wishlist){
			if(wish.getPid()==id)
			{
				wishDAO.add(wish);
				return "redirect:/cart/viewwish";
			}
		}
		
		Wish wish =new Wish();
		wish.setPid(id);
		wish.setCartId(Integer.parseInt(session.getAttribute("usercartid").toString()));
		wish.setPname(product.getName());
		wish.setPprice(product.getPrice());
		
		wishDAO.add(wish);
		return "redirect:/cart/viewwish";


	}

	
	@RequestMapping(value = "cart/viewwish")
	public String viewcart(Model model, HttpSession session) 
	{
		ArrayList<Wish> wishlist = (ArrayList<Wish>) wishDAO
				.show(Integer.parseInt(session.getAttribute("usercartid").toString()));
		model.addAttribute("title", "Wishlist");
		model.addAttribute("wishlist", wishlist);
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickWish", true);
		model.addAttribute("msg", false);
		return "page";

	}


	@RequestMapping(value = "deletewish/{id}")
	public String delcart(@PathVariable int id, Model model) {
			wishDAO.delete(id);
			return "redirect:/cart/viewwish";
	}

}
