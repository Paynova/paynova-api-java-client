package com.paynova.api.client.response;

import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.ProfileCardDetails;

public class GetCustomerProfileResponse extends Response{
	private String profileId;
	
	private ApiPropertyList<ProfileCardDetails> profileCards = new ApiPropertyList<ProfileCardDetails>();
	
	/**
	 * Returns the profileId
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	
	/**
	 * Details about any profile cards stored within the customer profile will be returned here.
	 * @return the profileCards
	 */
	public ApiPropertyList<ProfileCardDetails> getProfileCards() {
		return profileCards;
	}
	
	
	/**
	 * Get ProfileCardDetails stored in the profileCards list
	 * @param index of the ProfileCardDetails to get
	 * @return the ProfileCardDetails at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public ProfileCardDetails getProfileCardAtIndex(int index) {
		return profileCards.get(index);
	}
}
