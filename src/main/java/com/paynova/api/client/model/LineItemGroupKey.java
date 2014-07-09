package com.paynova.api.client.model;

public enum LineItemGroupKey {
	_EXTRA_("_EXTRA_"),
	_DISCOUNT_("_DISCOUNT_"),
	_SHIPPING_("_SHIPPING_"),
	_TAX_("_TAX_"),
	_ITEM_("_ITEM_");
	
	private String value;
	
	LineItemGroupKey(String value) {
		this.value = value;
	}
	
	public String toString(){
		return value;
	}
}
