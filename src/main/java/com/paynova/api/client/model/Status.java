package com.paynova.api.client.model;

public class Status extends ApiPropertyContainer{
	
	
	private boolean isSuccess;
	
	private int errorNumber;
	
	private String statusKey;
	
	private String statusMessage;
	
	private String exceptionDetails;
	
	ApiPropertyList<Error> errors;
	
	public Status() {
		errors = new ApiPropertyList<Error>();
	}
	
	/**
	 * Indicates whether or not the operation was successful.
	 * @return isSuccess
	 */
	public boolean getIsSuccess() {
		return isSuccess;
	}
	
	/**
	 * A numeric identifier indicating the operation's status. 
	 * For successful operations, this value will always be 0 (zero). 
	 * For more information, see the Error Codes page.
	 * @return the error number
	 */
	public int getErrorNumber() {
		return errorNumber;
	}
	
	/**
	 * A short textual representation of the operation's status. 
	 * For successful operations, this value will always be "SUCCESS"
	 * @return the status key
	 */
	public String getStatusKey() {
		return statusKey;
	}
	
	/**
	 * A detailed description of the operation's status.
	 * @return the status message
	 */
	public String getStatusMessage() {
		return statusMessage;
	}
	
	/**
	 * Exception details
	 * @return the exception details
	 */
	public String getExceptionDetails() {
		return exceptionDetails;
	}
	
	/**
	 * If any validation errors occurred, this collection will contain detailed information about the error(s).
	 * @return the list of errors
	 */
	public ApiPropertyList<Error> getErrors() {
		if(errors == null) {
			errors = new ApiPropertyList<Error>();
		}
		return errors;
	}
	
	/**
	 * Returns all the error information found in the error collection in a string.
	 * @param newlineDelimeter the line separator for each error
	 * @return a string with error information
	 */
	public String getAllErrorsAsString(String newlineDelimeter) {
		StringBuilder builder = new StringBuilder();
		for(Error error: getErrors()) {
			builder.append("code: ");
			builder.append(error.getErrorCode());
			builder.append(" fieldName: ");
			builder.append(error.getFieldName());
			builder.append(" message: ");
			builder.append(error.getMessage());
			builder.append(newlineDelimeter);
		}
		return builder.toString();
	}
}
