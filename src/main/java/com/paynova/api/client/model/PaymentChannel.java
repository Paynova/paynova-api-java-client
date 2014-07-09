package com.paynova.api.client.model;

public enum PaymentChannel {
	
	WEB(1),
	MAIL_TELEPHONE(2),
	RECURRING_SUBSCRIPTION(7);
	
	private int id;
	
	PaymentChannel(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
