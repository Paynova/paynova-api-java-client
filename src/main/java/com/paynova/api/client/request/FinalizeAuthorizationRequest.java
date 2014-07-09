package com.paynova.api.client.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.LineItem;

public class FinalizeAuthorizationRequest extends Request {
	
	private UUID orderId;
	
	private String transactionId;
	
	private BigDecimal totalAmount;
	
	private ApiPropertyList<LineItem> lineItems = new ApiPropertyList<LineItem>();
	
	private String invoiceId;
	
	/**
	 * Class constructor
	 * @param transactionId	the unique id of the transaction (authorization) that 
	 * you received from Paynova.
	 * @param totalAmount	the total amount to finalize. The amount must be equal 
	 * to or less than the original authorized amount.
	 */
	public FinalizeAuthorizationRequest(String transactionId, BigDecimal totalAmount) {
		this.setTransactionId(transactionId);
		this.setTotalAmount(totalAmount);
	}
	
	/**
	 * Class constructor
	 * @param orderId the orderId 
	 * @param transactionId	the unique id of the transaction (authorization) that 
	 * you received from Paynova.
	 * @param totalAmount	the total amount to finalize. The amount must be equal 
	 * to or less than the original authorized amount.
	 */
	public FinalizeAuthorizationRequest(UUID orderId, String transactionId, BigDecimal totalAmount) {
		this(transactionId,totalAmount);
		this.setOrderId(orderId);
	}
	
	/**
	 * 
	 * @return the orderId
	 */
	public UUID getOrderId() {
		return orderId;
	}
	
	/**
	 * The unique id you received from Paynova to identify the order.
	 * @param orderId
	 * @return the current FinalizeAuthorizationRequest object
	 */
	public FinalizeAuthorizationRequest setOrderId(UUID orderId) {
		this.orderId = orderId;
		return this;
	}
	
	/**
	 * 
	 * @return the transaction id
	 */
	public String getTransactionId() {
		return transactionId;
	}
	
	/**
	 * The unique id of the transaction (authorization) that you received from Paynova.
	 * @param transactionId
	 * @return the current FinalizeAuthorizationRequest object
	 */
	public FinalizeAuthorizationRequest setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	 *  The total amount to finalize. The amount must be equal to or less than the original 
	 *  authorized amount.
	 * @param totalAmount
	 * @return the current FinalizeAuthorizationRequest object
	 */
	public FinalizeAuthorizationRequest setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
	 * The line items
	 * @param lineItems
	 * @return the current FinalizeAuthorizationRequest object
	 */
	public FinalizeAuthorizationRequest setLineItems(ApiPropertyList<LineItem> lineItems) {
		this.lineItems = lineItems;
		return this;
	}
	
	/**
	 * 
	 * @return the invoice id
	 */
	public String getInvoiceId() {
		return invoiceId;
	}
	
	/**
	 * Your identifier for the invoice. For invoice payment methods, this identifier will 
	 * be printed on the invoice and is required.
	 * @param invoiceId
	 * @return the current FinalizeAuthorizationRequest object
	 */
	public FinalizeAuthorizationRequest setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
		return this;
	}
	
	@Override
	public String getRestPath() {
		return ((getOrderId()!=null)?"orders/"+getOrderId()+"/":"")+
				"transactions/"+getTransactionId()+"/"+
				"finalize/"+getTotalAmount().toPlainString();
	}
}
