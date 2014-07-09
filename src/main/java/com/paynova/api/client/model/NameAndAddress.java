package com.paynova.api.client.model;


public class NameAndAddress extends ApiPropertyContainer {
	
	private CompanyOrPersonName name;
	
	private Address address;
	
	public NameAndAddress() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return the name object
	 */
	public CompanyOrPersonName getName() {
		return name;
	}
	
	/**
	 * The name of the customer and/or company.
	 * @param name
	 * @return the current NameAndAddress object
	 */
	public NameAndAddress setName(CompanyOrPersonName name) {
		this.name = name;
		return this;
	}
	
	/**
	 * 
	 * @return the address object
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * The address
	 * @param address
	 * @return the current NameAndAddress object
	 */
	public NameAndAddress setAddress(Address address) {
		this.address = address;
		return this;
	}

}
