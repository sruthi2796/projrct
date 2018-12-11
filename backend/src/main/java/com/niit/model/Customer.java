package com.niit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private  int customerid;
	private String firstname;
	private String lastname;
	private String phonenumber;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	@OneToOne(cascade=CascadeType.ALL)
	private Billingaddress billingaddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Shippingaddress shippingaddress;
	public Customer() {
		System.out.println("customer object is created");
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Billingaddress getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(Billingaddress billingaddress) {
		this.billingaddress = billingaddress;
	}
	public Shippingaddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(Shippingaddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phonenumber=" + phonenumber + ", user=" + user + ", billingaddress=" + billingaddress
				+ ", shippingaddress=" + shippingaddress + "]";
	}
	
}
