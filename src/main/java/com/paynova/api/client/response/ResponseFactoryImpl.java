package com.paynova.api.client.response;



import com.paynova.api.client.http.HttpEvent;
import com.paynova.api.client.util.JsonParser;
import com.paynova.api.client.util.JsonParserImpl;

public class ResponseFactoryImpl implements ResponseFactory{

	public ResponseFactoryImpl() {
		
	}
	
	public <T extends Response> T createInstance(Class<T> type, HttpEvent httpEvent) {
		JsonParser parser = new JsonParserImpl();
		T response = parser.fromJson(httpEvent.getResponseBody(), type);
		response.setHttpEvent(httpEvent);
		
		return response;
	}
}