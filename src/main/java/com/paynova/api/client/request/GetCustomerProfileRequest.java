package com.paynova.api.client.request;

public class GetCustomerProfileRequest extends Request{
	
	private String profileId;
	
	/**
	 * Class constructor.
	 * 
	 * @param profileId the profileId of the customer
	 */
	public GetCustomerProfileRequest(String profileId) {
		this.setProfileId(profileId);
	}

	/**
	 * Returns the profileId
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	
	/**
	 * Your unique identifier for the customer profile
	 * @param profileId the profileId
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	@Override
	public String getRestPath() {
		return "customerprofiles/"+getProfileId();
	}
	
	
}
