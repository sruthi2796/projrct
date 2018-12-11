package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cartitems;
import com.niit.model.CustomerOrder;
@Repository("cartitemdaoimpl")
public class Cartitemdaoimpl implements Cartitemdao {
@Autowired
private SessionFactory sessionfactory;

	public void addtocart(Cartitems cartitems) {
		Session session=sessionfactory.openSession();
		session.save(cartitems);
		session.flush();
	
		
	}
	public void removeCartItem(int cartItemId) {
		Session session=sessionfactory.getCurrentSession();
		Cartitems cartItem=(Cartitems)session.get(Cartitems.class,cartItemId);
		session.delete(cartItem);
	}
	public List<Cartitems> getCart(String email) {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from Cartitems where user.email=?");
		query.setString(0, email);
		return query.list();
	}
	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		Session session=sessionfactory.getCurrentSession();
		session.save(customerOrder);
		return customerOrder;
	}



}
