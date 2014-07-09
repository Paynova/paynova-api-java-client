package com.paynova.api.client;

import java.math.BigDecimal;
import java.util.UUID;

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

public interface PaynovaClient {
	
	/**
	 * The Create Order service is used to create an order within Paynova's system.  You will 
	 * receive an identifier (GUID/UUID) for the order which will be used in subsequent requests 
	 * to Paynova such as, among others, Initialize Payment, Finalize Authorization and Refund Payment.
	 * @param orderNumber the String merchant orderNumber for the order
	 * @param totalAmount the BigDecimal totalAmount of the order
	 * @param currencyCode the String code the three-letter (alpha-3) ISO currency code or currency 
	 * number as per ISO 4217. 
	 * @throws PaynovaHttpException
	 * @return a CreateOrderResponse
	 */
	public CreateOrderResponse createOrder(String orderNumber, BigDecimal totalAmount, String currencyCode);
	
	/**
	 * The Create Order service is used to create an order within Paynova's system.  You will 
	 * receive an identifier (GUID/UUID) for the order which will be used in subsequent requests 
	 * to Paynova such as, among others, Initialize Payment, Finalize Authorization and Refund Payment.
	 * @param orderNumber the String merchant orderNumber for the order
	 * @param totalAmount the BigDecimal totalAmount of the order
	 * @param currencyCode the a case of the enum CurrencyCode
	 * @throws PaynovaHttpException
	 * @return a CreateOrderResponse
	 */
	public CreateOrderResponse createOrder(String orderNumber, BigDecimal totalAmount, CurrencyCode currencyCode);
	
	
	/**
	 * The Create Order service is used to create an order within Paynova's system.  You will 
	 * receive an identifier (GUID/UUID) for the order which will be used in subsequent requests 
	 * to Paynova such as, among others, Initialize Payment, Finalize Authorization and Refund Payment.
	 * @param request a CreateOrderRequest object
	 * @throws PaynovaHttpException
	 * @return a CreateOrderResponse
	 */
    public CreateOrderResponse createOrder(CreateOrderRequest request);
    
    
    /**
     * The Initialize Payment service is used to create an Payment Session within Paynova's system.  
     * You will receive an identifier (GUID/UUID) for the payment session. And an URL to redirect the customer
     * @param request a InitializePaymentRequest object
     * @throws PaynovaHttpException
     * @return a InitializePaymentResponse
     */
    public InitializePaymentResponse initializePayment(InitializePaymentRequest request);
	
    /**
     * The Finalize Authorization service is used to finalize all or part of an authorization. Depending on the 
     * payment method used to generate the authorization, this service has different effects.
     * @param request a FinalizeAuthorizationRequest object
     * @throws PaynovaHttpException
     * @return a FinalizeAuthorizationResponse
     */
	public FinalizeAuthorizationResponse finalizeAuthorization(FinalizeAuthorizationRequest request);
   
	
	/**
	 * The Refund Payment service is used to refund a Payment within Paynova's system.
	 * @param request a RefundPaymentRequest
	 * @throws PaynovaHttpException
	 * @return a RefundPaymentResponse
	 */
	public RefundPaymentResponse refundPayment(RefundPaymentRequest request);
	
	/**
	 * The Annul Authorization service is used to annul an authorization. Depending on the payment method used to 
	 * generate the authorization, this service has different effects. See the following table for information 
	 * about different payment method types. 
	 * @throws PaynovaHttpException
	 * @param request an AnnulAuthorizationRequest
	 */
    public void annulAuthorization(AnnulAuthorizationRequest request);
    
   /**
    * The Get Customer Profile service is used to retrieve information about a merchant customer profile stored 
    * at Paynova.
    * @param profileId the String profileId
    * @throws PaynovaHttpException
    * @return a GetCustomerProfileResponse
    */
    public GetCustomerProfileResponse getCustomerProfile(String profileId);
    
    /**
     * The Get Customer Profile service is used to retrieve information about a merchant customer profile stored 
     * at Paynova.
     * @param request a GetCustomerProfileRequest object
     * @throws PaynovaHttpException
     * @return a GetCustomerProfileResponse
     */
    public GetCustomerProfileResponse getCustomerProfile(GetCustomerProfileRequest request);
    
    /**
     * The Remove Customer Profile service is used to remove a customer profile and all related data.
     * @param profileId the String profileId 
     * @throws PaynovaHttpException
     */
    public void removeCustomerProfile(String profileId);

    /**
     * The Remove Customer Profile service is used to remove a customer profile and all related data.
     * @param request a GetCustomerProfileRequest object
     * @throws PaynovaHttpException
     */
    public void removeCustomerProfile(RemoveCustomerProfileRequest request);
    
    /**
     * The Remove Customer Profile Card service is used to remove a stored card from a customer profile.
     * @param profileId the String profileId
     * @throws PaynovaHttpException
     * @param cardId the UUID cardId
     */
    public void removeCustomerProfileCard(String profileId, UUID cardId);
    
    /**
     * The Remove Customer Profile Card service is used to remove a stored card from a customer profile.
     * @throws PaynovaHttpException
     * @param request a RemoveCustomerProfileCardRequest object
     */
    public void removeCustomerProfileCard(RemoveCustomerProfileCardRequest request);

}
