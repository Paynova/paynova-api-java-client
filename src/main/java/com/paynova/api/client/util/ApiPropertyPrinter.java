package com.paynova.api.client.util;

import com.paynova.api.client.model.ApiProperty;

public interface ApiPropertyPrinter {
	
	/**
	 * Recursively returns all properties (instance variables) contained in propertyObj
	 * as a nicely indented String. Properties marked transient will be excluded
	 * @param propertyObj the ApiProperty from which to return properties from
	 * @return String
	 */
	public String getApiProperties(ApiProperty propertyObj);
	
	
}
