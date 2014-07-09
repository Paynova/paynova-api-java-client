package com.paynova.api.client.response;

import java.util.UUID;



public class CreateOrderResponse extends Response {
	
	private UUID orderId;
	
	public CreateOrderResponse() {}
	
	/**
	 * If the request was successful and you received an HTTP 201 "Created" response, 
	 * this field will contain the order id (GUID) which you can use in subsequent calls 
	 * to the order API and for initializing payments.
	 * @return UUID the orderId
	 */
	public UUID getOrderId() {
		return orderId;
	}
}
