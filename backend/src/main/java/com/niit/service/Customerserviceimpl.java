package com.niit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.Customerdao;

import com.niit.model.Customer;
import com.niit.model.User;

@Service(value="customerserviceimpl")
@Transactional
public class Customerserviceimpl implements Customerservice {
	@Autowired
	 private Customerdao customerdao;

	public void registercustomer(Customer customer) {
		// TODO Auto-generated method stub
		 customerdao.registercustomer(customer);
	}
	public boolean isEmailUnique(String email)
	
	{
		
		return customerdao.isEmailUnique(email);
	}
	public User getuser(String email) {
		// TODO Auto-generated method stub
		return customerdao.getuser(email);
	}
	
	

}
