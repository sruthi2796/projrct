package com.niit.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Cartitems;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.Shippingaddress;
import com.niit.model.User;
import com.niit.service.Cartitemservice;
import com.niit.service.Customerservice;
import com.niit.service.Productservice;

@Controller
public class Cartitemscontroller {
	@Autowired
	private  Customerservice customerservice;
	@Autowired
	private Productservice productservice;
	@Autowired
	private Cartitemservice cartitemservice;
	@RequestMapping(value="/cart/getcart")
	public String getCart(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){ 
		String email=principal.getName();
		List<Cartitems> cartItems=cartitemservice.getCart(email);
		session.setAttribute("cartSize", cartItems.size());
		model.addAttribute("cartItems",cartItems);
		return "cart";
	}

	@RequestMapping(value="/cart/addtocart/{id}")
	public String addtocart(@PathVariable int id,@RequestParam int requestedquantity,@AuthenticationPrincipal Principal principal)
	{
	
		String email=  principal.getName();
		System.out.println(email);
		Product product=productservice.getProduct(id);
		User user=customerservice.getuser(email);
		List<Cartitems> cartItems=cartitemservice.getCart(email);
		for(Cartitems cartItem:cartItems){
			if(cartItem.getProduct().getId()==id){
				cartItem.setQuantity(requestedquantity);
				cartItem.setTotalprice(requestedquantity * product.getPrice());
			    cartitemservice.addtocart(cartItem);
			    return "redirect:/cart/getcart";
			}
		}
		Cartitems cartItem=new Cartitems();
		cartItem.setProduct(product);
		cartItem.setUser(user);
		cartItem.setQuantity(requestedquantity);
		cartItem.setTotalprice(requestedquantity * product.getPrice());
		
		cartitemservice.addtocart(cartItem);
		
		return "redirect:/cart/getcart";
	}
	
	@RequestMapping(value="/cart/removecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId){
		cartitemservice.removeCartItem(cartItemId);
		return "redirect:/cart/getcart";
	}

	
	@RequestMapping(value="/cart/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal){
		List<Cartitems> cartItems=cartitemservice.getCart(principal.getName());
		for(Cartitems cartItem:cartItems)
			cartitemservice.removeCartItem(cartItem.getCartItemId());
		return "redirect:/cart/getcart";
	}

	@RequestMapping(value="/cart/shippingaddressform")
	public String getShippingAddressForm(@AuthenticationPrincipal Principal principal,Model model){
		String email=principal.getName();
		//using email -> shippingaddress?
	     User user=customerservice.getuser(email);
	     Customer customer= user.getCustomer();
	     Shippingaddress shippingAddress=customer.getShippingaddress();
	     model.addAttribute("shippingaddress",shippingAddress);
		return "Shippingaddressform";
	}

	@RequestMapping(value="/cart/createorder")
	public String createCustomerOrder(@ModelAttribute Shippingaddress shippingaddress,
			Model model,
			@AuthenticationPrincipal Principal principal,HttpSession session){
		String email=principal.getName();
		
		//Get User object and List<CartItem>, for updating shippingaddress set the updated values
		User user=customerservice.getuser(email);
		List<Cartitems> cartItems=cartitemservice.getCart(email);
		Customer customer=user.getCustomer();
		customer.setShippingaddress(shippingaddress);
		
		user.setCustomer(customer);
		customer.setUser(user);
		
		
		//Calculate Grandtotal
		double grandTotal=0.0;
		for(Cartitems cartItem:cartItems){
			grandTotal=grandTotal+cartItem.getTotalprice();
		}
		
		
		//insert customerorder details in customerorder table
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		customerOrder.setGrandTotal(grandTotal);
		customerOrder.setUser(user);
		
		if(cartItems.size()>0)
		      cartitemservice.createCustomerOrder(customerOrder);//customerOrder -> user -> customer -> shippingaddres
		//Insert into customerorder table,update shippingaddress
		
		
		//Update the quantity of the product, clear the cart(remove cartitems from the cart)
		for(Cartitems cartItem:cartItems){
			Product product=cartItem.getProduct();
			product.setQuantity(product.getQuantity() - cartItem.getQuantity());
			productservice.updateproduct(product);//update the quantity of the product
			cartitemservice.removeCartItem(cartItem.getCartItemId());//delete from cartitem where cartitemid=?
		}
		session.setAttribute("cartSize", 0);
		
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("customerorder",customerOrder);
		return "orderdetails";
	}

	}


