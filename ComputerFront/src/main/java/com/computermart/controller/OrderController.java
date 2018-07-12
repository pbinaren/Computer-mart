package com.computermart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computermart.projectbackend.dao.AddressDao;
import com.computermart.projectbackend.dao.CartDao;
import com.computermart.projectbackend.dao.CategoryDao;
import com.computermart.projectbackend.dao.CustomerDao;
import com.computermart.projectbackend.dao.OrderDao;
import com.computermart.projectbackend.dao.ProductDao;
import com.computermart.projectbackend.model.Cart;
import com.computermart.projectbackend.model.Customer;
import com.computermart.projectbackend.model.CustomerOrder;
import com.computermart.projectbackend.model.Product;

@Controller
public class OrderController {
	
	@Autowired
	private OrderDao orderDAO;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private CartDao cartDAO;
	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDAO;
	@Autowired
	private CustomerDao customerDAO;
	@Autowired
	private AddressDao addressDAO;
	
	@RequestMapping(value = "invoice/{aid}")
	public String invoice(@PathVariable int aid,Model model,HttpSession session) {
		ArrayList<Cart> cartlist = (ArrayList<Cart>) cartDAO
				.show(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Long uuid=UUID.randomUUID().getMostSignificantBits();
		String id="OD"+uuid.toString().replace('-', '2');
		Iterator<Cart> cartiterator=cartlist.listIterator();
		while (cartiterator.hasNext())
		{
			Cart cart=cartiterator.next();
			Product product=productDAO.getProduct(cart.getPid());
			product.setQuantity(product.getQuantity()-cart.getQty());
			productDAO.saveOrUpdateProduct(product);
			
			CustomerOrder c=new CustomerOrder();
			c.setCartId(cart.getCartId());
			c.setOrderId(id);
			c.setAddid(aid);
			c.setDate(new Date());
			c.setPid(cart.getPid());
			c.setPname(cart.getPname());
			c.setQty(cart.getQty());
			c.setSubtotal(cart.getTotal());
			orderDAO.insert(c);
			cartDAO.delete(cart.getId());
			
		}
		try {
			String recipientAddress =SecurityContextHolder.getContext().getAuthentication().getName();
			Customer customer = customerDAO.showCustomer(recipientAddress);
			String uname = customer.getName(); 
			String usubject = "Order Confirmation";
			String finalmessage = "Hi"+ uname+":,\n\n Your order is confirmed.\n\n Your order number is"+id+"\n\n\n regards\n\n Admin";
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject(usubject);
			email.setText(finalmessage);
			mailSender.send(email);
		}
		catch(Exception e) {
			
		}
		return "redirect:/viewbill/"+id+"/"+aid;
	}
	
	@RequestMapping(value = "viewbill/{oid}/{aid}")
	public String viewbill(Model model, HttpSession session,@PathVariable String oid,@PathVariable int aid) 
	{
		List<CustomerOrder> custorder=orderDAO.viewreceipt(oid);
		model.addAttribute("title", "Order");
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickInvoice", true);
		model.addAttribute("baddress",addressDAO.show(aid));
		model.addAttribute("orderid",oid);
		model.addAttribute("orderdetail",custorder);
		session.setAttribute("cartsize", cartDAO
				.show(Integer.parseInt(session.getAttribute("usercartid").toString())).size());
		return "page";

	}
	
	@RequestMapping(value="viewallorders")
	public String viewallorders(Model model, HttpSession session) {
		
		int cartid = Integer.parseInt(session.getAttribute("usercartid").toString());
		model.addAttribute("title", "My Orders");
		model.addAttribute("orderlist",orderDAO.viewAllOrder(cartid));
		model.addAttribute("categorylist", categoryDAO.list());
		model.addAttribute("userClickAllOrder", true);
		return "page";
	}
	
	

}
