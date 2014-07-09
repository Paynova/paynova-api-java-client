package com.paynova.api.client.http;

import java.net.HttpURLConnection;


public interface Http {
	
	/**
	 * Do a GET REST operation with restPath
	 * @param restPath the path 
	 * @return HttpEvent
	 */
	public HttpEvent get(String restPath);
	
	/**
	 * Do a DELETE REST operation with restPath
	 * @param restPath the path 
	 * @return HttpEvent
	 */
	public HttpEvent delete(String restPath);
	
	/**
	 * Do a POST REST operation with restPath
	 * @param restPath the path 
	 * @param requestBody the contents to send 
	 * @return HttpEvent
	 */
	public HttpEvent post(String restPath, String requestBody); 
	
	
	/**
	 * Opens a url connection and returns a HttpURLConnection
	 * @param stringURL
	 * @return the HttpURLConnection
	 * @throws java.io.IOException
	 */
	public HttpURLConnection openConnection(String stringURL) throws java.io.IOException;
}
