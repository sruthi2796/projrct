package com.niit.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Category;
import com.niit.service.Categoryservice;

@Controller
public class Categorycontroller {
	@Autowired
	Categoryservice categoryservice;
	@RequestMapping("/allcategory")
	public String getallcategory(Model model)
	{
		List<Category> category=categoryservice.getallcategory();
		model.addAttribute("category", category);
		return "categorylist";
	}
	@RequestMapping("/admin/addcategory")
	public String addcategory(Model model)
	
	{
		Category category=new Category();
		model.addAttribute("category", category);
		return "addcategory";
	}
	@RequestMapping("/admin/categorylist")
	public String saveCategory(@ModelAttribute Category category)
	{
		categoryservice.addcategory(category);
		return "redirect:/allcategory";
	}
	@RequestMapping("/admin/viewcategory")
	public String viewproduct(@RequestParam int id,Model model) {
	Category category=categoryservice.getCategory(id);
	model.addAttribute("category",category);
	return "viewcategory";
		}
	@RequestMapping("/admin/deletecategory")
	public String deletecategory(@RequestParam int id)
	{
		
		categoryservice.DeleteCategory(id);
		return "redirect:/allcategory";
	}
	@RequestMapping("/admin/updatecategory")
	public String updatecategory(@RequestParam int id,Model model)
	{
		Category category=categoryservice.getCategory(id);
		model.addAttribute("category",category);
		return "updatecategory";
	}
	@RequestMapping("/admin/updatecate")
	public String update(@ModelAttribute Category category)
	{
		categoryservice.updateCategory(category);
		return"redirect:/allcategory";
	}

}
