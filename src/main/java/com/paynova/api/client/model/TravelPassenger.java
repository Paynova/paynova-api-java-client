package com.paynova.api.client.model;

public class TravelPassenger {
	
	private CompanyOrPersonName name;
	
	private String telephone;
	
	private String emailAddress;
	
	public TravelPassenger() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return the name
	 */
	public CompanyOrPersonName getName() {
		return name;
	}
	
	/**
	 * The passenger's name.
	 * @param name
	 * @return the current TravelPassenger object
	 */
	public TravelPassenger setName(CompanyOrPersonName name) {
		this.name = name;
		return this;
	}
	
	
	/**
	 * 
	 * @return the telephone number
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * The passenger's telephone number. The telephone number, including the national 
	 * prefix. For example, +46 8 555 55 55
	 * @param telephone
	 * @return the current TravelPassenger object
	 */
	public TravelPassenger setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}
	
	/**
	 * 
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * The passenger's e-mail address.
	 * @param emailAddress
	 * @return the current TravelPassenger object
	 */
	public TravelPassenger setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

}
