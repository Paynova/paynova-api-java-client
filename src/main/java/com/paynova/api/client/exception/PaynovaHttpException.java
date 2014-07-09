package com.paynova.api.client.exception;

import com.paynova.api.client.http.HttpEvent;
import com.paynova.api.client.model.Status;

public class PaynovaHttpException extends PaynovaException{
	
	private static final long serialVersionUID = 1L;
	
	private HttpEvent httpEvent;
	
	private Status status;
	
	public PaynovaHttpException(Throwable cause, String message) {
		super(message,cause);
		httpEvent = new HttpEvent();
		status = new Status();
	}
	public PaynovaHttpException(HttpEvent httpEvent, String message) {
		this(httpEvent, new Status(), message);
	}
	
	public PaynovaHttpException(HttpEvent httpEvent, Status status, String message) {
		super(message);
		this.httpEvent = httpEvent;
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public HttpEvent getHttpEvent() {
		return httpEvent;
	}
	
	
}
