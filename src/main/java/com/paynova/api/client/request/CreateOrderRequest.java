package com.paynova.api.client.request;

import java.math.BigDecimal;

import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.CurrencyCode;
import com.paynova.api.client.model.Customer;
import com.paynova.api.client.model.LineItem;
import com.paynova.api.client.model.NameAndAddress;

public class CreateOrderRequest extends Request{
	
	private String orderNumber;
	
	private BigDecimal totalAmount;
	
	private String currencyCode;
	
	private String salesChannel;
	
	private String salesLocationId;
	
	private Customer customer;
	
	private NameAndAddress billTo;
	
	private NameAndAddress shipTo;
	
	private ApiPropertyList<LineItem> lineItems = new ApiPropertyList<LineItem>();
	
	private String orderDescription;
	
	/**
	 * Class constructor
	 * @param orderNumber	your identifier for the order, most likely from your order management system.
	 * Validation: Free-text, preferably unique, minimum length = 4, maximum length = 50.
	 * @param totalAmount	the total amount of the order. If line items are provided, the value of this 
	 * field must equal the total sum of all line items.
	 * @param currencyCode	The three-letter (alpha-3) ISO currency code or currency number as per ISO 4217.
	 * Example values: "SEK", "752".
	 */
	public CreateOrderRequest(String orderNumber, BigDecimal totalAmount, String currencyCode) {
		setOrderNumber(orderNumber);
		
		setTotalAmount(totalAmount);
		
		setCurrencyCode(currencyCode);
		
	}
	
	/**
	 * Class constructor
	 * @param orderNumber	your identifier for the order, most likely from your order management system.
	 * Validation: Free-text, preferably unique, minimum length = 4, maximum length = 50.
	 * @param totalAmount	the total amount of the order. If line items are provided, the value of this 
	 * field must equal the total sum of all line items.
	 * @param currencyCode	see the enum  CurrencyCode for available currencies
	 */
	public CreateOrderRequest(String orderNumber, BigDecimal totalAmount, CurrencyCode currencyCode) {
		this(orderNumber,totalAmount,currencyCode.toString());
	}
	
	/**
	 * 
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	
	/**
	 * Your identifier for the order, most likely from your order management system.
	 * Validation: Free-text, preferably unique, minimum length = 4, maximum length = 50.
	 * @param orderNumber
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}
	
	/**
	 * 
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	/**
	 * The total amount of the order. If line items are provided, the value of this field must 
	 * equal the total sum of all line items.
	 * @param totalAmount
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}
	
	/**
	 * 
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	/**
	 * The three-letter (alpha-3) ISO currency code or currency number as per ISO 4217.
	 * Example values: "SEK", "752".
	 * @param currencyCode
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}
	
	/**
	 * @param currencyCode enum class CurrencyCode
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setCurrencyCode(CurrencyCode currencyCode) {
		this.setCurrencyCode(currencyCode.alpha3());
		return this;
	}
	
	/**
	 * 
	 * @return String the salesChannel
	 */
	public String getSalesChannel() {
		return salesChannel;
	}
	
	/**
	 * Your reference for the sales channel through which the customer is purchasing 
	 * goods/services. Validation: Free-text, minimum length = 0, maximum length = 50.
	 * @param salesChannel
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
		return this;
	}
	
	/**
	 * 
	 * @return the salesLocationId
	 */
	public String getSalesLocationId() {
		return salesLocationId;
	}
	
	/**
	 * Your identifier for the sales location. This might be a website URL, a country, 
	 * a call-center location, etc. Validation: Free-text, minimum length = 0, 
	 * maximum length = 50.
	 * @param salesLocationId
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setSalesLocationId(String salesLocationId) {
		this.salesLocationId = salesLocationId;
		return this;
	}
	
	/**
	 * 
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Information about the customer.
	 * @param customer
	 * @return the current CreateOrderRequest object
	 */
	public Customer setCustomer(Customer customer) {
		this.customer = customer;
		return this.customer;
	}
	
	/**
	 * 
	 * @return the billTo
	 */
	public NameAndAddress getBillTo() {
		return billTo;
	}
	
	/**
	 * The billing name and address of the customer/company, generally the "invoice address" 
	 * or "account holder" details.
	 * @param billTo
	 * @return the billTo object
	 */
	public NameAndAddress setBillTo(NameAndAddress billTo) {
		this.billTo = billTo;
		return this.billTo;
	}
	
	/**
	 * 
	 * @return the shipTo
	 */
	public NameAndAddress getShipTo() {
		return shipTo;
	}
	
	/**
	 * The ship-to name and address of the recipient.
	 * @param shipTo
	 * @return the shipTo object
	 */
	public NameAndAddress setShipTo(NameAndAddress shipTo) {
		this.shipTo = shipTo;
		return this.shipTo;
	}
	
	/**
	 * 
	 * @return the lineItems
	 */
	public ApiPropertyList<LineItem> getLineItems() {
		return lineItems;
	}
	
	/**
	 * The line items included in this order (what the customer is paying for). 
	 * You may include as many line items as required to specify the order.
	 * @param lineItems
	 * @return the lineItem object
	 */
	public ApiPropertyList<LineItem> setLineItems(ApiPropertyList<LineItem> lineItems) {
		this.lineItems = lineItems;
		return this.lineItems;
	}
	
	/**
	 * Add LineItem to the list
	 * @param lineItem the LineItem to add
	 * @return ApiPropertyList<LineItem> the list of LineItem's
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
	
	/**
	 * 
	 * @return the orderDescription
	 */
	public String getOrderDescription() {
		return orderDescription;
	}
	
	/**
	 * A free-text field which describes the order. This information is stored 
	 * on the transaction level.
	 * @param orderDescription
	 * @return the current CreateOrderRequest object
	 */
	public CreateOrderRequest setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
		return this;
	}
	
	@Override
	public String getRestPath() {
		return "orders/create"+
				"/"+getOrderNumber()+
				"/"+getTotalAmount().toPlainString()+
				"/"+getCurrencyCode();
	}
	
}
