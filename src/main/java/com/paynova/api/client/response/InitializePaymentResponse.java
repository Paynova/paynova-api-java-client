package com.paynova.api.client.response;

import java.net.URL;
import java.util.UUID;

public class InitializePaymentResponse extends Response{

	private UUID sessionId;
	
	private URL url;
	
	public InitializePaymentResponse() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The unique identifier (GUID) for the payment session. 
	 * This id will be used when opening/redirecting to our hosted payment pages.
	 * @return the sessionId as an UUID
	 */
	public UUID getSessionId(){
		return sessionId;
	}
	
	/**
	 * The prepared URL to our hosted payment page.
	 * @return the URL to the hosted payment page
	 */
	public URL getUrl() {
		return url;
	}

}
