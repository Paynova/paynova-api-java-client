package com.paynova.api.client.exception;


public class PaynovaException extends RuntimeException{


	private static final long serialVersionUID = -8810205230669458132L;

	public PaynovaException(String message,Throwable throwable) {
		super(message,throwable);
	}

	public PaynovaException(String message) {
		super(message);
	}

}
