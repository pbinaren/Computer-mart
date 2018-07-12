package com.computermart.projectbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ShipAddress
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int cartId;
	
	@NotEmpty(message = "address cannot be blank")
	private String name;
	
	@NotEmpty(message = "address cannot be blank")
	private String addressLine1;
	
	@NotEmpty(message = "address cannot be blank")
	private String addressLine2;
	
	@NotEmpty(message = "city cannot be blank")
	private String city;
	
	@NotEmpty(message = "state cannot be blank")
	private String state;
	
	@NotEmpty(message = "country cannot be blank")
	private String country;
	
	@NotEmpty(message = "pincode cannot be blank")
	@Size(min = 6, max = 6)
	@Pattern(regexp="[1-9][0-9]{5}", message="must start with either 1-9 and have 6 digits")
	private String pincode;

	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
