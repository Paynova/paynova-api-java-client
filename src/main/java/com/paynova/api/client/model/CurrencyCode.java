package com.paynova.api.client.model;

public enum CurrencyCode {
	
	UNITED_STATES_DOLLAR(	"840",		"USD"),
	EUROPEAN_EURO(			"978",		"EUR"),
	BRITISH_POUND(			"826",		"GBP"),
	SWEDISH_KRONA(			"752",		"SEK"),
	NORWEGIAN_KRONE(		"578",		"NOK"),
	DANISH_KRONE(			"208",		"DKK"),
	SWISS_FRANC(			"756",		"CHF"),
	AUSTRALIAN_DOLLAR(		"036",		"AUD"),
	NEW_ZEALAND_DOLLAR(		"554",		"NZD"),
	HONG_KONG_DOLLAR(		"344",		"HKD"),
	SINGAPORE_DOLLAR(		"702",		"SGD"),
	CANADIAN_DOLLAR(		"124",		"CAD"),
	POLISH_ZLOTY(			"985",		"PLN"),
	TURKISH_LIRA(			"949",		"TRY"),
	CHINESE_YUAN(			"156",		"CNY"),
	JAPANESE_YEN(			"392",		"JPY"),
	ISRAELI_NEW_SHEQEL(		"376",		"ILS");
	
	private final String iso;
	private final String alpha3;
	
	CurrencyCode(String iso, String alpha3) {
		this.iso = iso;
		this.alpha3 = alpha3;
	}
	
	public String iso(){ return iso;}
	public String alpha3(){ return alpha3;}
	
	public String toString(){ return alpha3; }
}
