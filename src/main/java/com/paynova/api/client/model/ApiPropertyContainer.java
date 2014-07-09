package com.paynova.api.client.model;

import com.paynova.api.client.util.ApiPropertyPrinter;

public abstract class ApiPropertyContainer implements ApiProperty {

	public ApiPropertyContainer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getApiProperties(ApiPropertyPrinter printer) {
		return printer.getApiProperties(this);
	}
}
