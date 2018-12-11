package com.niit.dao;

import java.util.List;

import com.niit.model.Cartitems;
import com.niit.model.CustomerOrder;

public interface Cartitemdao {
	public void addtocart(Cartitems cartitems);
	
    void removeCartItem(int cartItemId);
    List<Cartitems> getCart(String email);
    CustomerOrder createCustomerOrder(CustomerOrder customerOrder);


}
