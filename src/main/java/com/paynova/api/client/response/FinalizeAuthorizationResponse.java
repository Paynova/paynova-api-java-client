package com.paynova.api.client.response;

import java.math.BigDecimal;

public class FinalizeAuthorizationResponse extends Response {
	
	private BigDecimal totalAmountFinalized;
	
	private BigDecimal totalAmountPendingFinalization;
	
	private boolean canFinalizeAgain;
	
	private BigDecimal amountRemainingForFinalization;
	
	private String transactionId;
	
	private String batchId;
	
	private String acquirerId;
	
	
	
	public FinalizeAuthorizationResponse() { 
		
	}
	
	/**
	 * The amount that have been finalized
	 * @return the totalAmountFinalized
	 */
	public BigDecimal getTotalAmountFinalized() {
		return totalAmountFinalized;
	}
	
	/**
	 * The amount that previously have been finalized with the same orderId/transactionId
	 * and is in a pending state
	 * @return BigDecimal the totalAmountPendingFinalization
	 */
	public BigDecimal getTotalAmountPendingFinalization() {
		return totalAmountPendingFinalization;
	}

	/**
	 * Indicates whether or not the authorization can accept more finalizations.
	 * @return canFinalizeAgain
	 */
	public boolean getCanFinalizeAgain() {
		return canFinalizeAgain;
	}
	
	/**
	 * Indicates the amount remaining to be finalized for the authorization. If 
	 * canFinalizeAgain is false, the value for this property will be 0.00 (zero).
	 * @return amountRemainingForFinalization
	 */
	public BigDecimal getAmountRemainingForFinalization() {
		return amountRemainingForFinalization;
	}
	
	/**
	 * Paynova's transaction id for the finalization. Note that for some transactions, 
	 * this id may be the same as the original authorization transaction id.
	 * @return
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * 
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}
	
	/**
	 * 
	 * @return the acquirerId
	 */
	public String getAcquirerId() {
		return acquirerId;
	}

}
