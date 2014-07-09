package com.paynova.api.client.model;


public class Customer extends ApiPropertyContainer {
	
	private String customerId;
	
	private String emailAddress;
	
	private CompanyOrPersonName name;
	
	private String homeTelephone;
	
	private String workTelephone;
	
	private String mobileTelephone;
	
	private String governmentId;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * The company's name, if the purchase is being made on behalf 
	 * of a company. Validation: Maximum length = 50 characters.
	 * @param customerId
	 * @return the current Customer object
	 */
	public Customer setCustomerId(String customerId) {
		this.customerId = customerId;
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
	 * The customer's e-mail address.
	 * @param emailAddress
	 * @return the current Customer object
	 */
	public Customer setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	
	/**
	 * 
	 * @return the name of the customer and/or company.
	 */
	public CompanyOrPersonName getName() {
		return name;
	}
	
	/**
	 * The name of the customer and/or company.
	 * @param name
	 * @return the current Customer object
	 */
	public CompanyOrPersonName setName(CompanyOrPersonName name) {
		this.name = name;
		return this.name;
	}
	
	/**
	 * 
	 * @return the home telephone
	 */
	public String getHomeTelephone() {
		return homeTelephone;
	}
	
	/**
	 * The customer's home telephone number including the national prefix. 
	 * For example, +46 8 555 55 55
	 * @param homeTelephone
	 * @return the current Customer object
	 */
	public Customer setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
		return this;
	}
	
	/**
	 * 
	 * @return the work telephone
	 */
	public String getWorkTelephone() {
		return workTelephone;
	}
	
	/**
	 * The customer's work telephone number including the national 
	 * prefix. For example, +46 8 555 55 55
	 * @param workTelephone
	 * @return the current Customer object 
	 */
	public Customer setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
		return this;
	}
	
	/**
	 * 
	 * @return the mobile telephone
	 */
	public String getMobileTelephone() {
		return mobileTelephone;
	}
	
	/**
	 * The customer's mobile telephone number including the national prefix. 
	 * For example, +46 8 555 55 55
	 * @param mobileTelephone
	 */
	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}
	
	/**
	 * 
	 * @return the Goverment id (in sweden personnummer, in US social security number)
	 */
	public String getGovernmentId() {
		return governmentId;
	}
	
	/**
	 * The Goverment id (in Sweden personnummer, in the US social security number)
	 * @param governmentId
	 * @return
	 */
	public Customer setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
		return this;
	}
}
