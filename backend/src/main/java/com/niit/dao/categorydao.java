package com.niit.dao;

import java.util.List;

import com.niit.model.Category;


public interface categorydao {
	public List<Category> getallcategory();
	public void addcategory(Category category);
	public  void updateCategory(Category category);
	public Category getCategory(int id);
	public void DeleteCategory(int id);
}
