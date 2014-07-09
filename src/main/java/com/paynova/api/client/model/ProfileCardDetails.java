package com.paynova.api.client.model;

import java.util.UUID;

public class ProfileCardDetails extends ApiPropertyContainer{
	
	private UUID cardId;
	
	private int expirationYear;
	
	private int expirationMonth;
	
	private String firstSix;
	
	private String lastFour;
	
	public ProfileCardDetails(UUID cardId, int expirationYear, int expirationMonth, String firstSix, String lastFour) {
		this.cardId = cardId;
		
		this.expirationYear = expirationYear;
		
		this.expirationMonth = expirationMonth;
		
		this.firstSix = firstSix;
		
		this.lastFour = lastFour;
	}
	
	
	/**
	 * Paynova's unique identifier for the profile card stored within a customer profile. 
	 * This id should be used for subsequent requests to Paynova involving profile card payments.
	 * @return the UUID cardId
	 */
	public UUID getCardId() {
		return cardId;
	}
	
	/**
	 * The four-digit expiration year of the card.
	 * @return the int expirationYear
	 */
	public int getExpirationYear() {
		return expirationYear;
	}
	
	/**
	 * The two-digit expiration month of the card.
	 * @return the int expirationMonth
	 */
	public int getExpirationMonth() {
		return expirationMonth;
	}
	
	/**
	 * The first six digits of the card number (BIN/IIN).
	 * @return the String firstSix
	 */
	public String getFirstSix() {
		return firstSix;
	}
	
	/**
	 * The last four digits of the card number.
	 * @return the String lastFour
	 */
	public String getLastFour() {
		return lastFour;
	}

}
