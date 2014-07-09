package com.paynova.api.client.model;

import java.util.UUID;

public class ProfileCard extends ApiPropertyContainer {
	
	private UUID cardId;
		        
	private String cvc;
	
	/**
	 * Class constructor. 
	 * @param cardId paynova's unique id for the card stored in the customer profile.
	 */
	public ProfileCard(UUID cardId) {
		this.setCardId(cardId);
	}
	
	/**
	 * 
	 * @return the cardId
	 */
	public UUID getCardId() {
		return cardId;
	}
	
	/**
	 * Paynova's unique id for the card stored in the customer profile.
	 * @param cardId
	 * @return current ProfileCard object
	 */
	public ProfileCard setCardId(UUID cardId) {
		this.cardId = cardId;
		return this;
	}
	/**
	 * 
	 * @return	the cvc
	 */
	public String getCvc() {
		return cvc;
	}
	
	/**
	 * Depending on the payment channel and your acquiring agreement, 
	 * the card CVC (three or four digit security code) may be required. Paynova 
	 * will inform you if you are required to send this information.
	 * @param cvc
	 * @return current ProfileCard object
	 */
	public ProfileCard setCvc(String cvc) {
		this.cvc = cvc;
		return this;
	}

}
