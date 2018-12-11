package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository
public class Categorydaoimpl implements categorydao{
	@Autowired
	SessionFactory sessionfactory;
	public void addcategory(Category category) {
		Session session =sessionfactory.openSession();
		session.save(category);
		session.flush();
	}
	public List<Category> getallcategory() {
		Session session =sessionfactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> category=query.list();
		// TODO Auto-generated method stub
		return category;
	}
	
	public void DeleteCategory(int id) {
		// TODO Auto-generated method stub
		
		Session session =sessionfactory.openSession();
		Category category= (Category) session.get(Category.class,id);
		
		session.delete(category);
		session.flush();
		
	}
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Category category= (Category) session.get(Category.class,id);
		
		return category;
		
	}
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.openSession();
		session.update(category);
		session.flush();
		
	}

}
