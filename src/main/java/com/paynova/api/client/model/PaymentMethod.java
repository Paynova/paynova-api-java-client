package com.paynova.api.client.model;

public class PaymentMethod extends ApiPropertyContainer{
	
	/**
	 * payment cards constants
	 */
	public transient static final int CARD_VISA = 1;
	public transient static final int CARD_MASTERCARD = 2;
	public transient static final int CARD_AMERICAN_EXPRESS = 3;
	public transient static final int CARD_DINERS_CLUB = 4;
	public transient static final int CARD_MAESTRO = 12;
	
	/**
	 * bank public constants
	 */
	public transient static final int BANK_NORDEA_SWEDEN = 101;
	public transient static final int BANK_SWEDBANK = 102;
	public transient static final int BANK_HANDELSBANKEN = 103;
	public transient static final int BANK_SEB = 104;
	public transient static final int BANK_IDEAL = 110;
	public transient static final int BANK_LASTSCHRIFT_ELV = 111;
	public transient static final int BANK_NORDEA_FINLAND = 113;
	public transient static final int BANK_AKTIA = 114;
	public transient static final int BANK_DANSKE_BANK_FINLAND = 115;
	public transient static final int BANK_CHINA_PAY_CROSSBORDER = 116;
	public transient static final int BANK_POHJOLA = 117;
	public transient static final int BANK_UBERWEISUNG = 118;
	public transient static final int BANK_CHINA_PAY_DOMESTIC = 119;
	public transient static final int BANK_DANSKE_BANK_DENMARK = 121;
	public transient static final int BANK_SOFORTUBERWEISUNG_SOFORTBANKING = 123;
	
	/**
	 * E-account/wallet constants
	 */
	public transient static final int E_ACCOUNT_WALLET_SKRILL = 302;
	public transient static final int E_ACCOUNT_WALLET_PAYPAL = 304;
	public transient static final int E_ACCOUNT_WALLET_RESURS_BANK_CARD = 305;
	public transient static final int E_ACCOUNT_WALLET_RESURS_BANK_INVOICE = 306;
	
	private int id;
	
	/**
	 * Class constructor
	 * @param id	the id of the payment method.
	 */
	public PaymentMethod(int id) {
		this.setId(id);
	}
	
	/**
	 * 
	 * @return the payment method id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * The id of the payment method.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
