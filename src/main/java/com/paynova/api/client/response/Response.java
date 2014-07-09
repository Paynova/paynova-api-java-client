package com.paynova.api.client.response;



import com.paynova.api.client.http.HttpEvent;
import com.paynova.api.client.model.ApiProperty;
import com.paynova.api.client.model.Status;
import com.paynova.api.client.util.ApiPropertyPrinter;

public abstract class Response implements ApiProperty{
	
	private Status status;
	
	private transient HttpEvent httpEvent;
	public Response() {
	
	}
	/**
	 * Returns the HTTP event (transaction) the caused this Response
	 * @return the HttpEvent
	 */
	public HttpEvent getHttpEvent() {
		return httpEvent;
	}
	
	/**
	 * Set the HTTP event (transaction) the caused this Response 
	 * @param httpEvent
	 */
	public void setHttpEvent(HttpEvent httpEvent) {
		this.httpEvent = httpEvent;
	}
	
	/**
	 * The status object returned from the API REST server. Containing
	 * information about the request
	 * @return
	 */
	public Status getStatus() {
		return status;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.paynova.api.client.model.ApiProperty#getApiProperties(com.paynova.api.client.util.ApiPropertyPrinter)
	 */
	public String getApiProperties(ApiPropertyPrinter printer) {
		return printer.getApiProperties(this);
	}
}
