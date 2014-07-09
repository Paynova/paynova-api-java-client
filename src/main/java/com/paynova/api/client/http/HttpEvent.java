package com.paynova.api.client.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HttpEvent {

	private int code;
	
	private Map<String,List<String>> requestHeaders;
	
	private String requestBody;
	
	private Map<String,List<String>> responseHeaders;
	
	private String responseBody;
	
	/**
	 * Class constructor that constructs an empty HttpEvent
	 */
	public HttpEvent() {
		setCode(-1);
		setRequestHeaders(new HashMap<String,List<String>>());
		setRequestBody("");
		setResponseHeaders(new HashMap<String,List<String>>());
		setResponseBody("");
		
	}
	
	/**
	 * Class constructor
	 * @param code			the HTTP status code
	 * @param reqHeaders	the headers sent to the in the HTTP event 
	 * @param reqBody		the body sent to the in the HTTP event
	 * @param resHeaders	the headers in the HTTP response	
	 * @param resBody		the body in the HTTP response
	 */
	public HttpEvent(int code, Map<String, List<String>> reqHeaders, String reqBody, 
			Map<String, List<String>> resHeaders, String resBody
			){
		this.code = code;
		
		this.requestHeaders = reqHeaders;
		
		this.requestBody = reqBody;
		
		this.responseHeaders = resHeaders;
		
		this.responseBody = resBody;
	}
	
	/**
	 * Set HTTP coce
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * Sets the HTTP request headers used in the HTTP event
	 * @param requestHeaders the headers
	 */
	public void setRequestHeaders(Map<String, List<String>> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
	
	/**
	 * Sets the HTTP request body used in the HTTP event
	 * @param requestBody the HTTP body
	 */
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	
	/**
	 * Sets the HTTP response headers used in the HTTP event
	 * @param responseHeaders
	 */
	public void setResponseHeaders(Map<String, List<String>> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
	
	/**
	 * Sets HTTP response body used in the HTTP event
	 * @param responseBody	the HTTP body
	 */
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	/**
	 * Get the HTTP status code
	 * @return thet status code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Get the request headers for the HTTP event
	 * @return the request headers
	 */
	public Map<String, List<String>> getRequestHeaders() {
		return requestHeaders;
	}
	
	/**
	 * Returns all the response headers as an String
	 * @param newLineDelimeter	the delimiter to be used to delimit the headers
	 * @return String of headers
	 */
	public String getReqestHeadersAsString(String newLineDelimeter) {
		return getHeadersAsString(responseHeaders,newLineDelimeter);
	}
	
	/**
	 * Returns the HTTP request body for this HTTP event
	 * @return the request body
	 */
	public String getRequestBody() {
		return requestBody;
	}
	
	/**
	 * Returns the response headers for this HTTP event as MAP
	 * @return the response headers as MAP
	 */
	public Map<String,List<String>> getResponseHeaders() {
		return responseHeaders;
	}
	
	/**
	 * Get the response headers for this HTTP event
	 * @param newLineDelimeter	the delimiter to be used to delimit the headers
	 * @return String of headers
	 */
	public String getResponseHeadersAsString(String newLineDelimeter) {
		return getHeadersAsString(responseHeaders,newLineDelimeter);
	}
	
	/**
	 * Return the response body of this HTTP event
	 * @return String the response body 
	 */
	public String getResponseBody() {
		return responseBody;
	}
	
	private String getHeadersAsString(Map<String, List<String>> headers, String newLineDelimeter) {
		StringBuilder strHeaders = new StringBuilder();
		
		for (Map.Entry<String, List<String>> entry :responseHeaders.entrySet()) {
			String header = ((entry.getKey()!=null)?entry.getKey()+": ":" ");
			
			for(String value: entry.getValue()) {
				header+=value+" ";
			}
			
			strHeaders.append(header.trim()+newLineDelimeter);
		}
		return strHeaders.toString();
	}
}
