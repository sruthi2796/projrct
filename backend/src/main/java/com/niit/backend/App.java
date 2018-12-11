package com.niit.backend;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DBconfig.Dbconfiguration;
import com.niit.dao.Cartitemdao;
import com.niit.dao.Cartitemdaoimpl;
import com.niit.dao.Categorydaoimpl;
import com.niit.dao.Customerservicedaoimpl;
import com.niit.dao.productDAOconfig;
import com.niit.dao.ProductDAOimpl;
import com.niit.model.Authorities;
import com.niit.model.Cartitems;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.model.User;
import com.niit.service.Cartitemservice;
import com.niit.service.Cartitemserviceimpl;
import com.niit.service.Categoryservice;
import com.niit.service.Categoryserviceimpl;
import com.niit.service.Customerservice;
import com.niit.service.Customerserviceimpl;
import com.niit.service.Productservice;
import com.niit.service.Productserviceimpl;

/**
 * Hello world!.
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        	ApplicationContext context =new AnnotationConfigApplicationContext(Dbconfiguration.class,Cartitemdaoimpl.class,Cartitemserviceimpl.class,Categoryserviceimpl.class,Categorydaoimpl.class,ProductDAOimpl.class,Productserviceimpl.class,Customerserviceimpl.class,Customerservicedaoimpl.class);
        	productDAOconfig daoconfig =(productDAOconfig) context.getBean("daoimpl");
        	Cartitemservice cartitemservice=(Cartitemservice) context.getBean("cartitemserviceimpl");
        	Cartitemdao cartitemdao=(Cartitemdao) context.getBean("cartitemdaoimpl");
        	/*Cartitems cartitems =new Cartitems();
        	cartitems.setQuantity(8);
        	cartitems.setTotalprice(768.00);
        	cartitemdao.addtocart(cartitems);*/
        	
        	//Productservice productservice=(Productservice) context.getBean("productserviceimpl");
        	//Customerservice customerservice=(Customerservice) context.getBean("customerserviceimpl");
        	/*Categoryservice categoryservice=(Categoryservice) context.getBean("categoryserviceimpl");
            System.out.println( "Hello World!888" );
            Category category=new Category();
            category.setCategoryname("vehicle");
            categoryservice.addcategory(category);*/
            
        /*  for update and add
        	 Product product =new Product();
        	product.setPrice(2000);
        	product.setProductDesc("women's wear");
        	product.setProductName("saree");
        	product.setQuantity(56);
        	product.setId(5);
        	//daoconfig.updateProduct(product);
        	productservice.addproduct(product);*/
        	
        	
        	/*for getting details
        	  Product prod=productservice.getProduct(1);
        	System.out.println(prod.getPrice());
        	System.out.println(prod.getProductName());
        	System.out.println(prod.getProductDesc());*/
           //  productservice.Deleteproduct(1);
        /*	List<Product> product=productservice.getallproducts();
        	for(Product obj:product)
        	{
        		System.out.println(obj.getId()+"    "+obj.getProductDesc()+"  "+obj.getProductName()+"   "+obj.getQuantity());
        	}
        	}*/
        /*	List<Category> cat=productservice.getallcategory();
        	for(Category obj:cat)
        	{
        		System.out.println(obj.getCategoryid()+""+obj.getCategoryname());
        	}*/
        	/*Customer customer=new Customer();
        	
        	customer.setFirstname("sruthiusdhvziudhb");
        	customer.setLastname("vijayasdjfhukjsbfjk");
        	customer.setPhonenumber(672);
        	customerservice.registercustomer(customer);
        	
        	System.out.println("customer object is created");*/
    
   /* Category obj=new Category();
    obj.setCategoryname("furniture");
    daoconfig.addcategory(obj);*/
    
}
}
       
    

