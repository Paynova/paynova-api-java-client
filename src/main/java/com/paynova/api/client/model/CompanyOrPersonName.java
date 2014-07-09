package com.paynova.api.client.model;

public class CompanyOrPersonName  extends ApiPropertyContainer {
	
	private String companyName;
	
	private String title;
	
	private String firstName;
	
	private String middleNames;
	
	private String lastName;
	
	private String suffix;
	
	public CompanyOrPersonName() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * The company's name, if the purchase is being made on behalf of a company. 
	 * Validation: Maximum length = 50 characters.
	 * @param companyName
	 * @return the current CompanyOrPersonName object
	 */
	public CompanyOrPersonName setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	
	/**
	 * 
	 * @return the title of the person
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * The title. For example, "Mr.", "Mrs.". Validation: Maximum 
	 * length = 10 characters.
	 * @param title 
	 * @return the current CompanyOrPersonName object
	 */
	public CompanyOrPersonName setTitle(String title) {
		this.title = title;
		return this;
	}
	
	/**
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * The first name (given name). Validation: Maximum length = 50 characters.
	 * @param firstName
	 * @return the current CompanyOrPersonName object
	 */
	public CompanyOrPersonName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * 
	 * @return the middle names
	 */
	public String getMiddleNames() {
		return middleNames;
	}
	
	/**
	 * The middle names. Validation: Maximum length = 100 characters.
	 * @param middleNames
	 * @return the current CompanyOrPersonName object
	 */
	public CompanyOrPersonName setMiddleNames(String middleNames) {
		this.middleNames = middleNames;
		return this;
	}
	
	/**
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * The last name (surname). Validation: Maximum length = 50 characters.
	 * @param lastName
	 * @return the current CompanyOrPersonName object
	 */
	public CompanyOrPersonName setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	/**
	 * 
	 * @return the name suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	
	/**
	 * The name's suffix. For example, "Sr.", "Jr.". Validation: Maximum 
	 * length = 10 characters.
	 * @param suffix
	 * @return the current CompanyOrPersonName object
	 */
	public CompanyOrPersonName setSuffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

}
