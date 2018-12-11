package com.niit.dao;

import com.niit.model.Customer;
import com.niit.model.User;

public interface Customerdao {
	public void registercustomer(Customer customer);
	public boolean isEmailUnique(String email);
	public User getuser(String email);
}
