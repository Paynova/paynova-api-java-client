package com.paynova.api.client.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.LineItem;

public class RefundPaymentRequest extends Request {
	
	private UUID orderId;
	
	private String transactionId;
	
	private BigDecimal totalAmount;
	
	private ApiPropertyList<LineItem> lineItems = new ApiPropertyList<LineItem>();
	
	private String invoiceId;
	
	/**
	 * Class constructor
	 * @param orderId the unique id for the order which you received in the response from your 
	 * original Create Order request.
	 * @param transactionId the original id of the transaction to refund. The transaction must 
	 * have been successfully finalized before a refund may be processed.
	 * @param totalAmount	the total amount to refund. If provided, the amount must be equal 
	 * to or less than the finalized amount of the finalized transaction.
	 */
	public RefundPaymentRequest(UUID orderId, String transactionId, BigDecimal totalAmount) {
		this.setOrderId(orderId);
		this.setTransactionId(transactionId);
		this.setTotalAmount(totalAmount);
	}

	/**
	 * 
	 * @return the orderId
	 */
	public UUID getOrderId() {
		return orderId;
	}
	
	/**
	 * The unique id for the order which you received in the response from your original 
	 * Create Order request.
	 * @param orderId
	 * @return the current RefundPaymentRequest object
	 */
	public RefundPaymentRequest setOrderId(UUID orderId) {
		this.orderId = orderId;
		return this;
	}
	
	/**
	 * 
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	
	/**
	 * The original id of the transaction to refund. The transaction must have been successfully 
	 * finalized before a refund may be processed.
	 * @param transactionId
	 * @return the current RefundPaymentRequest object
	 */
	public RefundPaymentRequest setTransactionId(String transactionId) {
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
	 * The total amount to refund. If provided, the amount must be equal to or less than the 
	 * finalized amount of the finalized transaction.
	 * @param totalAmount
	 * @return the current RefundPaymentRequest object
	 */
	public RefundPaymentRequest setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}
	
	/**
	 * 
	 * @return the lineItems
	 */
	public ApiPropertyList<LineItem> getLineItems() {
		return lineItems;
	}
	
	/**
	 * The line items which are being refunded. Line items are required if the totalAmount is 
	 * less than the original finalized amount. Line items may not be specified for simple orders. 
	 * @param lineItems
	 * @return the current RefundPaymentRequest object
	 */
	public ApiPropertyList<LineItem> setLineItems(ApiPropertyList<LineItem> lineItems) {
		this.lineItems = lineItems;
		return this.lineItems;
	}
	
	/**
	 * 
	 * @return the invoiceId
	 */
	public String getInvoiceId() {
		return invoiceId;
	}
	
	/**
	 * Your identifier for the invoice. For invoice payment methods, this identifier will be printed 
	 * on the invoice and is required.
	 * @param invoiceId
	 * @return the current RefundPaymentRequest object
	 */
	public RefundPaymentRequest setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
		return this;
	}
	
	@Override
	public String getRestPath() {
		return "orders/"+
				"/"+getOrderId()+
				"/transactions"+
				"/"+getTransactionId()+
				"/refund"+
				"/"+getTotalAmount();
	}
}
