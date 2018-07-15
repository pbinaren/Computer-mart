package com.computermart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computermart.projectbackend.dao.CategoryDao;
import com.computermart.projectbackend.dao.ProductDao;


@Controller
public class FrontController {

	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDAO;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = { "/", "/home", "/index" })
	public String index(Model model) {

		model.addAttribute("title", "Home");
		model.addAttribute("userClickHome", true);
		model.addAttribute("categorylist", categoryDAO.list());
		return "page";

	}

	@RequestMapping(value = "about")
	public String about(Model model) {

		model.addAttribute("title", "About Us");

		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickAbout", true);
		return "page";

	}

	@RequestMapping(value = "contact")
	public String contact(Model model) {

		model.addAttribute("title", "Contact Us");

		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickContact", true);
		return "page";

	}
	
	@RequestMapping(value="sendmail")
	public String sendmail(HttpServletRequest request) {
		try {
			String recipientAddress ="computermartcomputerneeds@gmail.com";
			String uname = request.getParameter("uname");
			String usubject = request.getParameter("usubject");
			String uphno = request.getParameter("uphno");
			String umessage = request.getParameter("umessage");
			String finalmessage = "Hi Admin, "+umessage+" Contact me in:"+uphno+"\n\n\n regards\n\n"+uname;
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject(usubject);
			email.setText(finalmessage);
			mailSender.send(email);
		}
		catch(Exception e) {
			
		}
		return "redirect:/contact";
	}
	
	@RequestMapping(value = "products")
	public String products(Model model) {

		model.addAttribute("title", "Products");
		model.addAttribute("productlist", productDAO.getAllProducts());
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickProducts", true);
		return "page";

	}
	
	@RequestMapping(value = "prodcat/{cid}")
	public String prodCat(@PathVariable int cid, Model model) {
		
		model.addAttribute("title", "Products");
		model.addAttribute("productlist", productDAO.getCategoryProducts(cid));
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickProdCat", true);
		return "page";
	}
	
		
		
}
