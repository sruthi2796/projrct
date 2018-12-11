package com.niit.controller;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.model.Cartitems;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.service.Cartitemservice;
import com.niit.service.Categoryservice;
import com.niit.service.Productservice;
@Controller
public class homecontroller {
	@Autowired
	public Categoryservice categoryservice;
	@Autowired 
	public Productservice productservice;
	@Autowired
	Cartitemservice cartitemservice;
	@RequestMapping("/")
	public String homepage(@AuthenticationPrincipal Principal principal,HttpSession session,Model model)
	{
		List<Category> cat=categoryservice.getallcategory();
		    session.setAttribute("cat",cat);
		    if(principal!=null){
			String email=principal.getName();
			List<Cartitems> cartItems=cartitemservice.getCart(email);
			session.setAttribute("cartSize", cartItems.size());
	        } 
		    return "Header";
	}
	@RequestMapping("/about")
	public String aboutus()
	{
	return "aboutus";	
	}
	@RequestMapping("/catdisplay")
	public String displaycategory(@RequestParam int id,HttpSession session,Model model)
	{
		Category category=categoryservice.getCategory(id);
		model.addAttribute("category",category);
		List<Product> product=productservice.getallproducts();
		model.addAttribute("product", product);
		return "categorydisplay";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginError(Model model){
		model.addAttribute("loginError","Invalid email/password");
		return "redirect:/login";
	}
	@RequestMapping("/logout")
	public String logout(Model model){
		model.addAttribute("message","Loggedout successfully..");
		return "redirect:/login";
	}
	}
	

 