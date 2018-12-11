package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface productDAOconfig {
	public void addProduct(Product product); 
	public  void updateProduct(Product product);
	public Product getProduct(int id);
	public void Deleteproduct(int id);
	List<Product> getallproduct();
	

}
