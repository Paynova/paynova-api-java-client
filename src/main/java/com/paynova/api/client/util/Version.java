package com.paynova.api.client.util;

public class Version {
	
	private Version() {
		// TODO Auto-generated constructor stub
	}
	
	public static String get() {
		return PropertyFileReader.getPropertyFromFile("", "paynova.properties", "paynova.api.client.version");
	}
}
