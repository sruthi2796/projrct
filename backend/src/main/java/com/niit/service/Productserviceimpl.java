
package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.productDAOconfig;
import com.niit.model.Category;
import com.niit.model.Product;
@Service
@Transactional
public class Productserviceimpl implements Productservice {
@Autowired
public productDAOconfig daoconfig;
	public void addproduct(Product product) {
		// TODO Auto-generated method stub
		daoconfig.addProduct(product);

	}

	public void updateproduct(Product product) {
		daoconfig.updateProduct(product);
		// TODO Auto-generated method stub

	}

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product produ= daoconfig.getProduct(id);
		return produ;
	 
	}

	public void Deleteproduct(int id) {
		// TODO Auto-generated method stub
		System.out.println("service delete method");
		daoconfig.Deleteproduct(id);
		
	}

	public List<Product> getallproducts() {
		// TODO Auto-generated method stub
	List<Product> product	=daoconfig.getallproduct();
		return product;
	}

	
}
