package com.paynova.api.client;

import java.net.UnknownHostException;

import com.paynova.api.client.exception.PaynovaHttpException;

public enum ExceptionEnum {
		
	NONE(0, "None"),
	UNKNOWN_HOST(1, UnknownHostException.class.getSimpleName()),
	PAYNOVA_HTTP_EXCEPTION(2, PaynovaHttpException.class.getSimpleName());
	
	private final int e;
	private final String s;
	ExceptionEnum(int e, String s) {
		this.e = e;
		this.s = s;
	}
	
	public int intValue(){ return e;}
	public String toString(){ return s; }
}

