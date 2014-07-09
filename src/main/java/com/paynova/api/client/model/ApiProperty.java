package com.paynova.api.client.model;

import com.paynova.api.client.util.ApiPropertyPrinter;

public interface ApiProperty {
	/**
	 * Method to get all the properties in a current object. Implementing class should
	 * preferable avoid return transient class properties. The implementing class should
	 * also recursively return properties, that is return properties in properties.
	 * @param app The ApiPropertyPrinter to use the get the API-properties
	 * associated with the current ApiProperty
	 * @return a string with information about the properties in the current object
	 */
	public String getApiProperties(ApiPropertyPrinter app);
}
