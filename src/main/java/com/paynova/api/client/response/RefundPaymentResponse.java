package com.paynova.api.client.response;

import java.math.BigDecimal;

public class RefundPaymentResponse extends Response {
	
	private BigDecimal totalAmountRefunded;
	
	private BigDecimal totalAmountPendingRefund;
	
	private boolean canRefundAgain;
	
	private BigDecimal amountRemainingForRefund;
	
	private String transactionId;
	
	private String batchId;
	
	private String acquirerId;
	
	public RefundPaymentResponse() {
		
	}
	
	/**
	 * The amount that have been refunded
	 * @return totalAmountRefunded
	 */
	public BigDecimal getTotalAmountRefunded() {
		return totalAmountRefunded;
	}
	
	/**
	 * The amount that previously have been refunded with the same orderId/transactionId
	 * but is in pending state
	 * @return totalAmountPendingRefund
	 */
	public BigDecimal getTotalAmountPendingRefund() {
		return totalAmountPendingRefund;
	}
	
	/**
	 * 
	 * @return If finalize can be called again using the same orderId/transactionId
	 */
	public boolean getCanRefundAgain() {
		return canRefundAgain;
	}
	
	/**
	 * The amount that remains to be refunded with same orderId/transactionId
	 * @return amountRemainingForRefund
	 */
	public BigDecimal getAmountRemainingForRefund() {
		return amountRemainingForRefund;
	}
	
	/**
	 * Paynova's unique transaction id for the refund. This property is only returned for successful 
	 * @return	transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	
	/**
	 * 
	 * @return	batchId
	 */
	public String getBatchId() {
		return batchId;
	}

	/**
	 * 
	 * @return acquirerId
	 */
	public String getAcquirerId() {
		return acquirerId;
	}
}
