package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shippingaddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int shippingid;
	private String apartmentnumber;
	private String streetname;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public Shippingaddress() {
		System.out.println("shipping address is created");
	}
	
	public String getApartmentnumber() {
		return apartmentnumber;
	}

	public void setApartmentnumber(String apartmentnumber) {
		this.apartmentnumber = apartmentnumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getShippingid() {
		return shippingid;
	}
	public void setShippingid(int shippingid) {
		this.shippingid = shippingid;
	}
	
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
