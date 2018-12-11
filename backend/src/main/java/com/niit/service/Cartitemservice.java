package com.niit.service;

import java.util.List;

import com.niit.model.Cartitems;
import com.niit.model.CustomerOrder;

public interface Cartitemservice {
	void addtocart(Cartitems cartitems);
	void removeCartItem(int cartItemId);
    List<Cartitems> getCart(String email);
    CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}
