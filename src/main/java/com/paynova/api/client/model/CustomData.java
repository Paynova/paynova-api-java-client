package com.paynova.api.client.model;

public class CustomData extends ApiPropertyContainer {
	
	private String key;
	
	private String value;
	
	/**
	 * Class constructor.
	 * @param key	the key identifying the value pair.
	 * @param value the value of the this value pair
	 */
	public CustomData(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}
	
	/**
	 * 
	 * @return the key identifying this value pair
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * The key identifying the value pair.
	 * @param key
	 * @return the current CustomData object
	 */
	public CustomData setKey(String key) {
		this.key = key;
		return this;
	}
	
	/**
	 * 
	 * @return the value of this key-value pair
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * The value of the this value pair
	 * @param value
	 * @return the current CustomData object
	 */
	public CustomData setValue(String value) {
		this.value = value;
		return this;
	}

}
