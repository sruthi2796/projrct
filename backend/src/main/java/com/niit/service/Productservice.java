package com.niit.service;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface Productservice {
	public void addproduct(Product product);
	public void updateproduct(Product product);
	public Product getProduct(int id);
	public void Deleteproduct(int id);
public List<Product> getallproducts();
}
