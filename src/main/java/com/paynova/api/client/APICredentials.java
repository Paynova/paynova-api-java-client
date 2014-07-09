package com.paynova.api.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.org.apache.commons.codec.binary.Base64;

public class APICredentials {
	private URL endpointURL;
	private String username;
	private String password;
	
	public APICredentials(String endpoint, String username, String password) {
		
		this.setEndpointURL(endpoint);
		this.setUsername(username);
		this.setPassword(password);

	}
	public URL getEndpointURL() {
		return endpointURL;
	}

	public void setEndpointURL(String endpoint) {
		try{
			this.endpointURL = new URL(endpoint);
		}catch(MalformedURLException mue) {
			throw new PaynovaHttpException(mue.getCause(),mue.getMessage());
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getBasicAuthStringBase64Encoded() {
		return "Basic " + Base64.encodeBase64String((getUsername() + ":" + getPassword()).getBytes()).trim();
	}
}
