package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Authorities;
import com.niit.model.Customer;
import com.niit.model.User;


@Repository(value="customerservicedaoimpl")

public class Customerservicedaoimpl implements Customerdao {
	@Autowired
	SessionFactory sessionfactory;
	public void registercustomer(Customer customer) {
		Session session=sessionfactory.getCurrentSession();
		//Make user property in Authorities to refer user object
		User user=customer.getUser();
		Authorities authorities=user.getAuthorities();
		authorities.setUser(user);//SET A VALUE FOR FK IN AUTHORITIES TABL
		session.save(customer);

		}
		public boolean isEmailUnique(String email) {//james.s@niit.com
			Session session=sessionfactory.getCurrentSession();
			User user=(User)session.get(User.class, email);//select * from user where email='james.s@niit.com'
			if(user==null)
				return true;
			else 
				return false;
		}
		public User getuser(String email) {
			Session session=sessionfactory.getCurrentSession();
			User user=(User) session.get(User.class,email);
			return user;
		}

		
	}


	

	

