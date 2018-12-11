package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.Cartitemdao;
import com.niit.model.Cartitems;
import com.niit.model.CustomerOrder;
@Service
@Transactional
public class Cartitemserviceimpl implements Cartitemservice {
	@Autowired
	private Cartitemdao cartitemdao;

	public void addtocart(Cartitems cartitems) {
		cartitemdao.addtocart(cartitems);

	}

	public void removeCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		cartitemdao.removeCartItem(cartItemId);
	}

	public List<Cartitems> getCart(String email) {
		// TODO Auto-generated method stub
		return cartitemdao.getCart(email);
	}

	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		return cartitemdao.createCustomerOrder(customerOrder);
	}

}
