package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Product;
@Repository(value="daoimpl")
public class ProductDAOimpl implements productDAOconfig {
	@Autowired
	SessionFactory sessionfactory;

	public void addProduct(Product product) {
		Session session =sessionfactory.openSession();
		session.save(product);
		session.flush();
	
		// TODO Auto-generated method stub
		
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.openSession();
		session.update(product);
		session.flush();
		
	}
	
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Product product=(Product) session.get(Product.class,id);
		session.flush();
		return product;
		
	}

	public void Deleteproduct(int id) {
		// TODO Auto-generated method stub
		System.out.println("delete product");
		System.out.println("id value" +id);
		Session session =sessionfactory.openSession();
		Product product=(Product) session.get(Product.class,id);
		System.out.println(product.getId());
		session.delete(product);
		session.flush();
		
	}

	public List<Product> getallproduct() {
		Session session =sessionfactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> product= query.list();
		// TODO Auto-generated method stub
		return product;
	}

	
}
