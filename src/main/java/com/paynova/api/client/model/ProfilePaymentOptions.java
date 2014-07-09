package com.paynova.api.client.model;

public class ProfilePaymentOptions {
	
	private String profileId;
	        
	private ProfileCard profileCard;
	        
	private boolean displaySaveProfileCardOption;
	
	/**
	 * Class constructor.
	 * @param profileId		your identifier for the customer profile.
	 */
	public ProfilePaymentOptions(String profileId) {
		setProfileId(profileId);
	}
	
	/**
	 * Class constructor.
	 * @param profileId		your identifier for the customer profile.
	 * @param profileCard	the profile card use in the payment. If the payment is to be performed on a stored 
	 * profile card, this parameter is required.
	 */
	public ProfilePaymentOptions(String profileId, ProfileCard profileCard) {
		setProfileId(profileId);
		setProfileCard(profileCard);
	}
	
	/**
	 * 
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	
	/**
	 * Your identifier for the customer profile.
	 * @param profileId
	 * @return the current ProfilePaymentOptions object
	 */
	public ProfilePaymentOptions setProfileId(String profileId) {
		this.profileId = profileId;
		return this;
	}
	
	/**
	 * 
	 * @return the ProfileCard
	 */
	public ProfileCard getProfileCard() {
		return profileCard;
	}

	/**
	 * The profile card use in the payment. If the payment is to be performed on a stored profile card, 
	 * this parameter is required.
	 * @param profileCard
	 * @return the current ProfilePaymentOptions object
	 */
	public ProfilePaymentOptions setProfileCard(ProfileCard profileCard) {
		this.profileCard = profileCard;
		return this;
	}
	
	/**
	 * 
	 * @return whether to display save option or not 
	 */
	public boolean getDisplaySaveProfileCardOption() {
		return displaySaveProfileCardOption;
	}
	/**
	 * If you would like the customer to choose whether or not to save their card in your customer profile 
	 * on Paynova's page, then set this option to true. The logic works as follows:
	 * - If you provide a profile id in profilePaymentOptions and this value is false, the card will be 
	 * saved and the customer will not be presented with an option on Paynova's payment page.
	 * - If you provide a profile id in profilePaymentOptions and this value is not present (null), the 
	 * card will be saved.
	 * - If you provide a profile id in profilePaymentOptions and this value is true, the customer will 
	 * be presented with the option to choose whether or not they want their card saved on Paynova's 
	 * payment page. If the customer opts to save their card, you will receive a profile card identifier 
	 * after the payment has been completed (assuming the customer pays with a card), otherwise the card 
	 * will not be saved to the customer's profile and you will not receive an identifier.
	 * @param displaySaveProfileCardOption
	 * @return the current ProfilePaymentOptions object
	 */
	public ProfilePaymentOptions setDisplaySaveProfileCardOption(boolean displaySaveProfileCardOption) {
		this.displaySaveProfileCardOption = displaySaveProfileCardOption;
		return this;
	}

}
