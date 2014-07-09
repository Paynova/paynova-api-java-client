package com.paynova.api.client.request;

import com.paynova.api.client.model.ApiProperty;
import com.paynova.api.client.util.ApiPropertyPrinter;

public abstract class Request implements ApiProperty{
	
	/**
	 * Returns the rest path used for specific Request
	 * @return an valid rest path for this request
	 */
	public abstract String getRestPath();
	
	/*
	 * (non-Javadoc)
	 * @see com.paynova.api.client.model.ApiProperty#getApiProperties(com.paynova.api.client.util.ApiPropertyPrinter)
	 */
	public String getApiProperties(ApiPropertyPrinter printer) {
		return printer.getApiProperties(this);
	}
	
}
