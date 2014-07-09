package com.paynova.api.client.model;

import java.net.URL;

public class InterfaceOptions extends ApiPropertyContainer {
	
	/**
	 * interfaceId options
	 */
	public static final int ID_AERO = 5;
	
	/**
	 * layoutName options
	 */
	public transient static final String LAYOUT_PAYNOVA_FULLPAGE_1 = "Paynova_FullPage_1";
	public transient static final String LAYOUT_PAYNOVA_MOBILE_1 = "Paynova_Mobile_1";
	
	private int interfaceId;
    
    private String layoutName;
    
    private String themeName;
    	
    private String customerLanguageCode;
    
    private boolean displayLineItems;
    
    private URL urlRedirectSuccess;
    
    private URL urlRedirectCancel;
    
    private URL urlRedirectPending;
    
    private URL urlCallback;
    
    /**
     * Class constructor
     * @param interfaceId 	the id of the web interface to use. Currently, the only value accepted is 5 for our 
	 * Aero interface, helper constant ID_AERO exists in this class.
     * @param customerLanguageCode 	the three-letter language code identifying the language that the payment interface should 
	 * be displayed to the customer in.
     * @param urlRedirectSuccess 	the URL on your website to which we should redirect the customer upon successful payment.
     * @param urlRedirectCancel 	the URL on your website to which we should redirect the customer upon the customer canceling 
	 * payment or running out of payment attempts.
     * @param urlRedirectPending 	the URL on your website to which we should redirect the customer upon a payment being in either 
	 * an indeterminable or pending state. Payment methods which are not "real-time" 
	 * (for example, Laschrift/ELV, Uberweisung) use this status.
     */
	public InterfaceOptions(int interfaceId, String customerLanguageCode, URL urlRedirectSuccess, URL urlRedirectCancel, URL urlRedirectPending) {
		this.setInterfaceId(interfaceId);
		this.setCustomerLanguageCode(customerLanguageCode);
		this.setUrlRedirectSuccess(urlRedirectSuccess);
		this.setUrlRedirectCancel(urlRedirectCancel);
		this.setUrlRedirectPending(urlRedirectPending);
	}
	
	/**
	 * 
	 * @return the interfaceId
	 */
	public int getInterfaceId() {
		return interfaceId;
	}
	
	/**
	 * The id of the web interface to use. Currently, the only value accepted is 5 for our 
	 * Aero interface, helper constant ID_AERO exists in this class.
	 * @param interfaceId
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setInterfaceId(int interfaceId) {
		this.interfaceId = interfaceId;
		return this;
	}
	
	/**
	 * 
	 * @return the layoutName 
	 */
	public String getLayoutName() {
		return layoutName;
	}
	
	/**
	 * The name of the layout to use. The following values are public layouts which you may 
	 * use: Paynova_Fullpage_1 (LAYOUT_PAYNOVA_FULLPAGE_1), Paynova_Mobile_1 (LAYOUT_PAYNOVA_MOBILE_1)
	 * @param layoutName
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setLayoutName(String layoutName) {
		this.layoutName = layoutName;
		return this;
	}
	
	/**
	 * 
	 * @return the themeName
	 */
	public String getThemeName() {
		return themeName;
	}
	
	/**
	 * The name of your custom hosted theme at Paynova. Note that this field only applies 
	 * to merchants who have setup a custom theme with us and specifying an invalid value 
	 * will result in your payment page not rendering properly.
	 * @param themeName
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setThemeName(String themeName) {
		this.themeName = themeName;
		return this;
	}
	
	/**
	 * 
	 * @return the customerLanguageCode
	 */
	public String getCustomerLanguageCode() {
		return customerLanguageCode;
	}

	/**
	 * The three-letter language code identifying the language that the payment interface should 
	 * be displayed to the customer in.
	 * @param customerLanguageCode
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setCustomerLanguageCode(String customerLanguageCode) {
		this.customerLanguageCode = customerLanguageCode;
		return this;
	}
	
	/**
	 * 
	 * @return if to displayLineItems or not
	 */
	public boolean getDisplayLineItems() {
		return displayLineItems;
	}
	
	/**
	 * Indicates whether or not order line-items should be displayed to the customer. The default 
	 * is true if you send line items, false if you do not send line items.
	 * @param displayLineItems
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setDisplayLineItems(boolean displayLineItems) {
		this.displayLineItems = displayLineItems;
		return this;
	}
	
	/**
	 * 
	 * @return the URL to redirect the user on a SUCCESSFUL payment
	 */
	public URL getUrlRedirectSuccess() {
		return urlRedirectSuccess;
	}
	
	/**
	 * The URL on your website to which we should redirect the customer upon successful payment.
	 * @param urlRedirectSuccess
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setUrlRedirectSuccess(URL urlRedirectSuccess) {
		this.urlRedirectSuccess = urlRedirectSuccess;
		return this;
	}
	
	/**
	 * 
	 * @return URL where to redirect the user upon cancel
	 */
	public URL getUrlRedirectCancel() {
		return urlRedirectCancel;
	}
	
	/**
	 * The URL on your website to which we should redirect the customer upon the customer canceling 
	 * payment or running out of payment attempts.
	 * @param urlRedirectCancel
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setUrlRedirectCancel(URL urlRedirectCancel) {
		this.urlRedirectCancel = urlRedirectCancel;
		return this;
	}
	
	/**
	 * 
	 * @return the URL where to redirect the user upon a pending state
	 */
	public URL getUrlRedirectPending() {
		return urlRedirectPending;
	}
	
	/**
	 * The URL on your website to which we should redirect the customer upon a payment being in either 
	 * an indeterminable or pending state. Payment methods which are not "real-time" 
	 * (for example, Laschrift/ELV, Uberweisung) use this status.
	 * @param urlRedirectPending
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setUrlRedirectPending(URL urlRedirectPending) {
		this.urlRedirectPending = urlRedirectPending;
		return this;
	}
	
	/**
	 * 
	 * @return the URL where the API server sends EVENT HOOK NOTIFICATIONS
	 */
	public URL getUrlCallback() {
		return urlCallback;
	}
	
	/**
	 * A URL to your system which we can send Event Hook Notifications (EHNs) to. If this parameter is 
	 * provided, it will be used instead of any statically configured EHN URLs.
	 * @param urlCallback
	 * @return the current InterfaceOptions object
	 */
	public InterfaceOptions setUrlCallback(URL urlCallback) {
		this.urlCallback = urlCallback;
		return this;
	}

}
