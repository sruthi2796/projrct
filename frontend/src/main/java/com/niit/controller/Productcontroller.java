package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.service.Categoryservice;

import com.niit.service.Productservice;

@Controller
public class Productcontroller {
	@Autowired
	public Productservice productservice;
	@Autowired
	public Categoryservice categoryservice;
	@RequestMapping("/list")
	public String getallproducts(Model model,HttpSession session)
	{
		
		List<Product> prod=productservice.getallproducts();
		model.addAttribute("products",prod);
	return "listofproducts";
	}
	
	
	//FOR ADDING PRODUCTS
	@RequestMapping("/admin/addproduct")
	public String getproductform(Model model)
	{
		Product prod=new Product();
		List<Category> category=categoryservice.getallcategory();
		model.addAttribute("product",prod);
		model.addAttribute("categories",category);
		System.out.println(category);
		
		return "productform";
	}
	
	@RequestMapping("/admin/saveproducts")
	public String saveproductform(@Valid @ModelAttribute Product product, BindingResult result,Model model,HttpServletRequest request)
	{
		if(result.hasErrors())
	{
			List<Category> categories=categoryservice.getallcategory();
	model.addAttribute("categories",categories);
	
		return "productform";
	}
	productservice.addproduct(product);
	MultipartFile img=product.getImage();
	System.out.println(request.getServletContext().getRealPath("/"));
	
	//Defining a path
	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
	
	//Create a file in the path
	
	try {
		if(img!=null && !img.isEmpty()){
		File file=new File(path.toString());
		img.transferTo(file);
		}
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return  "redirect:/list";	
	}
	//for getting one product info
	@RequestMapping("/info")
	public String getproduct(@RequestParam int id,Model model)
	{
		Product product=productservice.getProduct(id);
		
		model.addAttribute("product",product);
		return "productdetails";
	}
	//for deleting
	@RequestMapping("/admin/delete")
	public String deleteproduct(@RequestParam int id)
	{
	     productservice.Deleteproduct(id);

		return "redirect:/list";
	}
	//for updating
	@RequestMapping("/admin/update")
	public String update(@RequestParam int id,Model model)
	{
		Product product=productservice.getProduct(id);
		List<Category> category=categoryservice.getallcategory();
		model.addAttribute("categories",category);
		model.addAttribute("product",product);
		return"updateproduct";
	}
	@RequestMapping("/admin/details")
	public String updatemethod(@Valid @ModelAttribute Product product,BindingResult result,Model model,HttpServletRequest request)
	{
		if(result.hasErrors())
	{
		List<Category> categories=categoryservice.getallcategory();
		model.addAttribute("categories",categories);
		return"updateproduct";
	}
		productservice.updateproduct(product);
		MultipartFile img=product.getImage();
		System.out.println(request.getServletContext().getRealPath("/"));
		
		//Defining a path
		Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
		
		//Create a file in the path
		
		try {
			if(img!=null && !img.isEmpty()){
			File file=new File(path.toString());
			img.transferTo(file);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "redirect:/list";
	}
	@RequestMapping(value="/listof")
	public String listofproducts(@RequestParam String searchcondition ,Model model)
	{
		if(searchcondition.equals("all"))
		
		model.addAttribute("searchcondition", "");
			
		
		else
		
			model.addAttribute("searchcondition", searchcondition);
			List<Product> product=productservice.getallproducts();
		
		model.addAttribute("products",product);
		return"listofproducts";
	}
}
