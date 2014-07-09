package com.paynova.api.client.model;



public class Error extends ApiPropertyContainer {
	
	private String errorCode;
	
	private String fieldName;
	
	private String message;
	
	public Error() {
	
	}
	
	/**
	 * A short textual representation of the type of error incurred. For example, 
	 * "NotNull", "GreaterThan", etc.
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	/**
	 * The name of the field/property for which the validation error was incurred.
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 * A detailed description of the validation error.
	 * @return the error message
	 */
	public String getMessage() {
		return message;
	}
}
