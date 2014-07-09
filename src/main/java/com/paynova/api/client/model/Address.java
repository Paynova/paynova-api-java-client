package com.paynova.api.client.model;

public class Address extends ApiPropertyContainer{
	
	private String street1;
	
	private String street2;
	
	private String street3;
	
	private String street4;
	
	private String city;
	
	private String postalCode;
	
	private String regionCode;
	
	private String countryCode;
	
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 
	 * @return street1
	 */
	public String getStreet1() {
		return street1;
	}

	
	/**
	 * The street address, line 1.
	 * @param street1
	 * @return the current Address object
	 */
	public Address setStreet1(String street1) {
		this.street1 = street1;
		return this;
	}

	/**
	 * 
	 * @return street2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * The street address, line 2.
	 * @param street2
	 * @return the current Address object
	 */
	public Address setStreet2(String street2) {
		this.street2 = street2;
		return this;
	}

	/**
	 * 
	 * @return street 3
	 */
	public String getStreet3() {
		return street3;
	}

	/**
	 * The street address, line 3.
	 * @param street3
	 * @return the current Address object
	 */
	public Address setStreet3(String street3) {
		this.street3 = street3;
		return this;
	}

	/**
	 * 
	 * @return street4
	 */
	public String getStreet4() {
		return street4;
	}

	/**
	 * The street address, line 4.
	 * @param street4
	 * @return the current Address object
	 */
	public Address setStreet4(String street4) {
		this.street4 = street4;
		return this;
	}

	/**
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * The city.
	 * @param city
	 * @return the current Address object
	 */
	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	/**
	 * 
	 * @return the zip/postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * The postal/zip code.
	 * @param postalCode
	 * @return the current Address object
	 */
	public Address setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * 
	 * @return the region code
	 */
	public String getRegionCode() {
		return regionCode;
	}

	/**
	 * The region code/state code.
	 * @param regionCode
	 * @return the current Address object
	 */
	public Address setRegionCode(String regionCode) {
		this.regionCode = regionCode;
		return this;
	}

	/**
	 * 
	 * @return the contry code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * The country code. This may be the two-letter (alpha-2), three-letter (alpha-3) code or 
	 * the ISO country number as per ISO 3166-1. Example values: "SE", "SWE", "752".
	 * @param countryCode
	 * @return the current Address object
	 */
	public Address setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

}
