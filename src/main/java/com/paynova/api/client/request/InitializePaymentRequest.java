package com.paynova.api.client.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.CustomData;
import com.paynova.api.client.model.InterfaceOptions;
import com.paynova.api.client.model.LineItem;
import com.paynova.api.client.model.PaymentChannel;
import com.paynova.api.client.model.PaymentMethod;
import com.paynova.api.client.model.ProfilePaymentOptions;

public class InitializePaymentRequest extends Request {
	
	private UUID orderId;
	        
	private BigDecimal totalAmount;
	        
	private ApiPropertyList<PaymentMethod> paymentMethods = new ApiPropertyList<PaymentMethod>();
	        
    private int paymentChannelId;
    
    private ApiPropertyList<CustomData> customData = new ApiPropertyList<CustomData>();
    
    private int sessionTimeout;
    
    private String routingIndicator;
    
    private String fraudScreeningProfile;
    
    private InterfaceOptions interfaceOptions;
    
    private ProfilePaymentOptions profilePaymentOptions;
    
    private ApiPropertyList<LineItem> lineItems = new ApiPropertyList<LineItem>();
	
	/**
	 * Class Constructor. The Initialize Payment service is used to create an Payment Session 
	 * within Paynova's system.  
	 *
	 * @param orderId	the unique identifier (GUID) that you received from Paynova in the 
	 * response from Create Order.
	 * @param totalAmount	the total amount that should be processed for this payment. This 
	 * must be equal to or less than the original order amount, and less than the original order amount minus any payments which have been already made on the order.
	 * @param paymentChannelId  the channel of payment see helper enum {@link PaymentChannel} 
	 * @param interfaceOptions configuration for the customer Payment process
	 */
	public InitializePaymentRequest(UUID orderId, BigDecimal totalAmount, int paymentChannelId, InterfaceOptions interfaceOptions) {
		this.setOrderId(orderId);
		this.setTotalAmount(totalAmount);
		this.setPaymentChannelId(paymentChannelId);
		this.setInterfaceOptions(interfaceOptions);
	}
	
	/**
	 * Class Constructor. The Initialize Payment service is used to create an Payment Session 
	 * within Paynova's system.  
	 *
	 * @param orderId	the unique identifier (GUID) that you received from Paynova in the 
	 * response from Create Order.
	 * @param totalAmount	the total amount that should be processed for this payment. This 
	 * must be equal to or less than the original order amount, and less than the original order amount minus any payments which have been already made on the order.
	 * @param paymentChannel  the channel of payment see helper enum {@link PaymentChannel} 
	 * @param interfaceOptions configuration for the customer Payment process
	 */
	public InitializePaymentRequest(UUID orderId, BigDecimal totalAmount, PaymentChannel paymentChannel, InterfaceOptions interfaceOptions) {
		this(orderId, totalAmount, paymentChannel.getId(),interfaceOptions);
	}
	
	/**
	 * 
	 * @return the orderId
	 */
	public UUID getOrderId() {
		return orderId;
	}
	
	/**
	 * The unique identifier (GUID) that you received from Paynova in the response from Create Order.
	 * @param orderId
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setOrderId(UUID orderId) {
		this.orderId = orderId;
		return this;
	}
	
	/**
	 * 
	 * @return the total amount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	/**
	 * The total amount that should be processed for this payment. This must be equal to or less than 
	 * the original order amount, and less than the original order amount minus any payments which 
	 * have been already made on the order.
	 * @param totalAmount
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}
	
	/**
	 * 
	 * @return the payment method list
	 */
	public ApiPropertyList<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}
	
	/**
	 * One or more payment methods to display to the customer. If you do not send a value, all 
	 * configured and available payment methods will be displayed.
	 * @param paymentMethods
	 * @return
	 */
	public ApiPropertyList<PaymentMethod> setPaymentMethods(ApiPropertyList<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
		return this.paymentMethods;
	}
	
	/**
	 * Add a payment method
	 * @param paymentMethod
	 * @return the list of payment methods
	 * @see {@link #setPaymentMethods(ApiPropertyList) setPaymentMethods}
	 */
	public ApiPropertyList<PaymentMethod> addPaymentMethod(PaymentMethod paymentMethod) {
		paymentMethods.add(paymentMethod);
		return paymentMethods;
	}
	
	/**
	 * Get a PaymentMethod stored in the payment method list
	 * @param index of the payment method to get
	 * @return the PaymentMethod at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public PaymentMethod getPaymentMethodAtIndex(int index) {
		return paymentMethods.get(index);
	}
	
	/**
	 * Remove a PaymentMethod stored in the payment method list
	 * @param index of the payment method to remove
	 * @return the PaymentMethod at the specified position in the list (just removed)
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public PaymentMethod removePaymentMethodAtIndex(int index) {
		return paymentMethods.remove(index);
	}
	
	/**
	 * 
	 * @return the paymentChannelId
	 */
	public int getPaymentChannelId() {
		return paymentChannelId;
	}
	
	/**
	 * The channel of payment.
	 * @param paymentChannel
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setPaymentChannelId(PaymentChannel channel) {
		paymentChannelId = channel.getId();
		return this;
	}
	
	/**
	 * The channel of payment see helper enum PaymentChannel
	 * @param paymentChannelId
	 * @see PaymentChannel
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setPaymentChannelId(int paymentChannelId) {
		this.paymentChannelId = paymentChannelId;
		return this;
	}

	/**
	 * 
	 * @return the Custom Data
	 */
	public ApiPropertyList<CustomData> getCustomData() {
		return customData;
	}
	
	/**
	 * Collection of up to 10 (ten) private key-value data fields to store as meta-data 
	 * on the transaction. This data can be viewed in Merchant Services and is returned 
	 * in the GetOrder response object. We do not use this data for processing transactions.
	 * @param customData
	 * @return customData	the list of CustomData
	 */
	public ApiPropertyList<CustomData> setCustomData(ApiPropertyList<CustomData> customData) {
		this.customData = customData;
		return customData;
	}
	
	/**
	 * Add CustomData to the list
	 * @param cd the CustomData to add
	 * @return the list of CustomData
	 * @see {@link #setCustomData(ApiPropertyList) setCustomData}
	 */
	public ApiPropertyList<CustomData> addCustomData(CustomData cd) {
		customData.add(cd);
		return customData;
	}
	
	/**
	 * Get CustomData stored in the CustomData list
	 * @param index of the CustomData to get
	 * @return the CustomData at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public CustomData getCustomDataAtIndex(int index) {
		return customData.get(index);
	}
	
	/**
	 * Remove CustomData stored in the CustomData list
	 * @param index of the CustomData to remove
	 * @return the (just removed) CustomData at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public CustomData removeCustomDataAtIndex(int index) {
		return customData.remove(index);
	}
	
	/**
	 * 
	 * @return the session timeout seconds
	 */
	public int getSessionTimeout() {
		return sessionTimeout;
	}
	
	/**
	 * The time-to-live (TTL) of the session, in seconds, before the session times out.
	 * @param sessionTimeout
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
		return this;
	}
	
	/**
	 * 
	 * @return the routing indicator
	 */
	public String getRoutingIndicator() {
		return routingIndicator;
	}

	/**
	 * The name or id of the routing table to use when processing payments.
	 * This is an advanced configuration, contact Paynova before using
	 * @param routingIndicator
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setRoutingIndicator(String routingIndicator) {
		this.routingIndicator = routingIndicator;
		return this;
	}
	
	/**
	 * 
	 * @return the fraud screening profile
	 */
	public String getFraudScreeningProfile() {
		return fraudScreeningProfile;
	}
	
	/**
	 * The name or id of the fraud screening profile (named set of fraud screening rules) to use.
	 * This is an advanced configuration, contact Paynova before using
	 * @param fraudScreeningProfile
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setFraudScreeningProfile(String fraudScreeningProfile) {
		this.fraudScreeningProfile = fraudScreeningProfile;
		return this;
	}
	
	/**
	 * 
	 * @return configuration for the customer Payment process
	 */
	public InterfaceOptions getInterfaceOptions() {
		return interfaceOptions;
	}
	
	/**
	 * The configuration for the customer Payment process
	 * @param interfaceOptions
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setInterfaceOptions(InterfaceOptions interfaceOptions) {
		this.interfaceOptions = interfaceOptions;
		return this;
	}

	public ProfilePaymentOptions getProfilePaymentOptions() {
		return profilePaymentOptions;
	}
	
	/**
	 * Configuration for using/storing profile cards
	 * @param profilePaymentOptions
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setProfilePaymentOptions(ProfilePaymentOptions profilePaymentOptions) {
		this.profilePaymentOptions = profilePaymentOptions;
		return this;
	}
	
	/**
	 * 
	 * @return the line item list
	 */
	public ApiPropertyList<LineItem> getLineItems() {
		return lineItems;
	}
	
	/**
	 * Line items included in this payment.
	 * @param lineItems
	 * @return the current InitializePaymentRequst object
	 */
	public InitializePaymentRequest setLineItems(ApiPropertyList<LineItem> lineItems) {
		this.lineItems = lineItems;
		return this;
	}
	
	/**
	 * Add LineItem to the list
	 * @param lineItem the LineItem to add
	 * @return the list of LineItem's
	 * @see {@link #setLineItems(ApiPropertyList) setLineItems}
	 */
	public ApiPropertyList<LineItem> addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
		return lineItems;
	}
	
	/**
	 * Get LineItem stored in the LineItem list
	 * @param index of the LineItem to get
	 * @return the LineItem at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public LineItem getLineItemAtIndex(int index) {
		return lineItems.get(index);
	}
	
	
	/**
	 * Get LineItem stored in the LineItem list
	 * @param index of the LineItem to remove
	 * @return the (just removed) LineItem at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public LineItem removeLineItemAtIndex(int index) {
		return lineItems.remove(index);
	}
	
	@Override
	public String getRestPath() {
		return "orders/"+
				getOrderId()+
				"/initializePayment";
	}
	
}
