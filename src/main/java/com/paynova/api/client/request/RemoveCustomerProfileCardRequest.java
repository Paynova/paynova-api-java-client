package com.paynova.api.client.request;

import java.util.UUID;

public class RemoveCustomerProfileCardRequest extends Request{
	
	private String profileId;
	
	private UUID cardId;
	
	/**
	 * Class constructor.
	 * 
	 * @param profileId the profileId of the customer to remove
	 */
	public RemoveCustomerProfileCardRequest(String profileId, UUID cardId) {
		setProfileId(profileId);
		setCardId(cardId);
	}
	
	/**
	 * Returns the profileId
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	
	/**
	 * Your unique identifier for the customer profile stored at Paynova. 
	 * @param profileId the profileId
	 * @return the current RemoveCustomerProfileCardRequest object
	 */
	public RemoveCustomerProfileCardRequest setProfileId(String profileId) {
		this.profileId = profileId;
		return this;
	}
	
	/**
	 * Returns the cardId 
	 * @return the UUID cardId
	 */
	public UUID getCardId() {
		return cardId;
	}
	
	/**
	 * Paynova's GUID identifier for the card associated with the customer profile.
	 * @param cardId the UUID cardId
	 * @return the current RemoveCustomerProfileCardRequest object
	 */
	public RemoveCustomerProfileCardRequest setCardId(UUID cardId) {
		this.cardId = cardId;
		return this;
	}

	@Override
	public String getRestPath() {
		return "customerprofiles/"+getProfileId()+
				"/cards/"+getCardId();
	}

}
