package com.paynova.api.client;

import java.math.BigDecimal;
import java.util.UUID;

import com.paynova.api.client.http.Http;
import com.paynova.api.client.http.HttpImpl;
import com.paynova.api.client.model.CurrencyCode;
import com.paynova.api.client.request.AnnulAuthorizationRequest;
import com.paynova.api.client.request.CreateOrderRequest;
import com.paynova.api.client.request.FinalizeAuthorizationRequest;
import com.paynova.api.client.request.GetCustomerProfileRequest;
import com.paynova.api.client.request.InitializePaymentRequest;
import com.paynova.api.client.request.RefundPaymentRequest;
import com.paynova.api.client.request.RemoveCustomerProfileCardRequest;
import com.paynova.api.client.request.RemoveCustomerProfileRequest;
import com.paynova.api.client.response.CreateOrderResponse;
import com.paynova.api.client.response.FinalizeAuthorizationResponse;
import com.paynova.api.client.response.GetCustomerProfileResponse;
import com.paynova.api.client.response.InitializePaymentResponse;
import com.paynova.api.client.response.RefundPaymentResponse;
import com.paynova.api.client.response.ResponseFactory;
import com.paynova.api.client.response.ResponseFactoryImpl;
import com.paynova.api.client.util.JsonParser;
import com.paynova.api.client.util.JsonParserImpl;

public class PaynovaClientImpl implements PaynovaClient {
	
	private ResponseFactory responseFactory;
	private JsonParser jsonParser;
	private Http http;
	
	/**
	 * 
	 * @param endpoint the String Payonva REST API endpoint url 
	 * @param username the String Paynova REST API username to use for basic authentication
	 * @param password the String Paynova REST API password to user for basic authentication
	 */
	public PaynovaClientImpl(String endpoint, String username, String password) {
		this(new HttpImpl(new APICredentials(endpoint, username, password)));
	}
	
	/**
	 * If to use a custom Http client when communication with Paynova REST API.
	 * @param http
	 */
	public PaynovaClientImpl(Http http) {
		setHttp(http);
		
		setResponseFactory(new ResponseFactoryImpl());
		
		setJsonParser(new JsonParserImpl());
	}
	
	
	public CreateOrderResponse createOrder(String orderNumber,BigDecimal totalAmount, String currencyCode) {
		return createOrder(new CreateOrderRequest(orderNumber,totalAmount,currencyCode));
	}
	
	
	public CreateOrderResponse createOrder(String orderNumber, BigDecimal totalAmount, CurrencyCode currencyCode) {
		return createOrder(new CreateOrderRequest(orderNumber,totalAmount,currencyCode));
	}

	public CreateOrderResponse createOrder(CreateOrderRequest request) {
		return responseFactory.createInstance(
				CreateOrderResponse.class, 
				http.post(
						request.getRestPath(), jsonParser.toJson(request)
				)
		);
	}
	
	public InitializePaymentResponse initializePayment(InitializePaymentRequest request) {
		return responseFactory.createInstance(
				InitializePaymentResponse.class, 
				http.post(
						request.getRestPath(), jsonParser.toJson(request)
				)
		);
	}

	public FinalizeAuthorizationResponse finalizeAuthorization(FinalizeAuthorizationRequest request) {
		return responseFactory.createInstance(
				FinalizeAuthorizationResponse.class, 
				http.post(
						request.getRestPath(), jsonParser.toJson(request)
				)
		);
	}
	
	public RefundPaymentResponse refundPayment(RefundPaymentRequest request) {
		return responseFactory.createInstance(
				RefundPaymentResponse.class, 
				http.post(
						request.getRestPath(), jsonParser.toJson(request)
				)
		);
	}
	
	public void annulAuthorization(AnnulAuthorizationRequest request) {
		http.post(request.getRestPath(), jsonParser.toJson(request));
	}
	
	public GetCustomerProfileResponse getCustomerProfile(String profileId) {
		return getCustomerProfile(new GetCustomerProfileRequest(profileId));
	}

	public GetCustomerProfileResponse getCustomerProfile(GetCustomerProfileRequest request) {
		return responseFactory.createInstance(
				GetCustomerProfileResponse.class,
				http.get(request.getRestPath())
		);
	}

	public void removeCustomerProfile(String profileId) {
		removeCustomerProfile(new RemoveCustomerProfileRequest(profileId));
	}

	public void removeCustomerProfile(RemoveCustomerProfileRequest request) {
		http.delete(request.getRestPath());
	}

	public void removeCustomerProfileCard(String profileId, UUID cardId) {
		removeCustomerProfileCard(new RemoveCustomerProfileCardRequest(profileId, cardId));
	}

	public void removeCustomerProfileCard(RemoveCustomerProfileCardRequest request) {
		http.delete(request.getRestPath());
	}
	
	public ResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(ResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public JsonParser getJsonParser() {
		return jsonParser;
	}
	
	public void setJsonParser(JsonParser jsonParser) {
		this.jsonParser = jsonParser;
	}
	
	public Http getHttp() {
		return http;
	}

	public void setHttp(Http http) {
		this.http = http;
	}

}
