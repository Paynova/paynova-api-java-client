package com.paynova.api.client.response;

import com.paynova.api.client.http.HttpEvent;

public interface ResponseFactory {
	
	/**
	 * Creates a sub type of Response from a HttpEvent (the responseBody)
	 * @param type the type of Class to create instance of
	 * @param httpEvent the content from which to initialize a sub type of Response
	 * @return an instance of a sub type of Response
	 */
	public <T extends Response> T createInstance(Class<T> type, HttpEvent httpEvent);
	
}
