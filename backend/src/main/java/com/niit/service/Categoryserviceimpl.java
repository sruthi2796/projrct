package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.categorydao;
import com.niit.model.Category;

@Service
@Transactional
public class Categoryserviceimpl implements Categoryservice{
	@Autowired
	categorydao categorydao;
	
	public List<Category> getallcategory() {
		// TODO Auto-generated method stub
		List<Category> category=categorydao.getallcategory();
		return category;
	}

	public void addcategory(Category category) {
		categorydao.addcategory(category);
		// TODO Auto-generated method stub
		
	}
	public void updateCategory(Category category) {
		categorydao.updateCategory(category);
		// TODO Auto-generated method stub

	}

	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		Category category= categorydao.getCategory(id);
		return category;
	 
	}

	public void DeleteCategory(int id) {
		// TODO Auto-generated method stub
		System.out.println("service delete method");
		categorydao.DeleteCategory(id);
		
	}
}
