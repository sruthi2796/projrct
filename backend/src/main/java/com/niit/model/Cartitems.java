package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cartitems {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartItemId;
	private int quantity;
	private double totalprice;
	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public double getTotalprice()
	{
		return totalprice;
	}
	public void setTotalprice(double totalprice) 
	{
		this.totalprice = totalprice;
	}
	public Cartitems() 
	{
		System.out.println("cartitems object is created");
	}
	@Override
	public String toString() {
		return "Cartitems [cartItemId=" + cartItemId + ", quantity=" + quantity + ", totalprice=" + totalprice
				+ ", user=" + user + ", product=" + product + "]";
	}
	

}
