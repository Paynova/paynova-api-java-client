package com.paynova.api.client.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.LineItem;

public class AnnulAuthorizationRequest extends Request {
	
	private UUID orderId;
	
	private String transactionId;
	
	private BigDecimal totalAmount;
	
	private ApiPropertyList<LineItem> lineItems = new ApiPropertyList<LineItem>();
	
	/**
	 * Class constructor
	 * 
	 * @param transactionId the transaction id you received from Paynova pointing to an 
	 * authorized payment transaction.
	 * @param totalAmount 	the total amount to annul. Depending on the payment method, 
	 * partial annulments may or may not be allowed
	 */
	public AnnulAuthorizationRequest(String transactionId, BigDecimal totalAmount) {
		setTransactionId(transactionId);
		setTotalAmount(totalAmount);
	}
	
	/**
	 * Class constructor
	 * @param orderId the unique identifier (GUID) that you received from Paynova in 
	 * the response from Create Order.
	 * @param transactionId the transaction id you received from Paynova pointing to an 
	 * authorized payment transaction.
	 * @param totalAmount 	the total amount to annul. Depending on the payment method, 
	 * partial annullments may or may not be allowed
	 */
	public AnnulAuthorizationRequest(UUID orderId, String transactionId, BigDecimal totalAmount) {
		setTransactionId(transactionId);
		setTotalAmount(totalAmount);
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
	 * @return the current AnnulAuthorizationRequest object
	 */
	public AnnulAuthorizationRequest setOrderId(UUID orderId) {
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
	 * The transaction id you received from Paynova pointing to an authorized payment transaction.
	 * @param transactionId the transactionId
	 * @return the current AnnulAuthorizationRequest object
	 */
	public AnnulAuthorizationRequest setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	 * The total amount to annul. Depending on the payment method, partial annullments may or may not be allowed
	 * @param totalAmount
	 * @return the current AnnulAuthorizationRequest object
	 */
	public AnnulAuthorizationRequest setTotalAmount(BigDecimal totalAmount) {
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
	 * The line items which are being annulled. Line items are only required when annuling an amount less 
	 * than the original transaction amount. Line items are only allowed when the original order was a detailed order.
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
	 * @return the list of LineItem's
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
		return ((getOrderId()!=null)?"orders/"+getOrderId()+"/":"")+
				"/transactions/"+getTransactionId()+
				"/annul/"+getTotalAmount();
	}
}
