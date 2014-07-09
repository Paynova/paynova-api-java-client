package com.paynova.api.client.model;

public class TravelTicket extends ApiPropertyContainer {
	
	private String serviceId;
	
	private String ticketNumber;
	
	private boolean isRefundable;
	
	private boolean isRebookable;
	
	private TravelPassenger passenger;
	
	/**
	 * Class constructor.
	 * @param isRefundable	indicates whether or not this ticket is refundable.
	 * @param isRebookable	indicates whether or not this ticket is re-bookable.
	 * @param passenger		the passenger traveling on this ticket.
	 */
	public TravelTicket(boolean isRefundable, boolean isRebookable, TravelPassenger passenger) {
		this.setRefundable(isRefundable);
		this.setRebookable(isRebookable);
		this.setPassenger(passenger);
	}
	
	/**
	 * 
	 * @return the service id
	 */
	public String getServiceId() {
		return serviceId;
	}
	
	/**
	 * The carrier's service id for this ticket. Validation: 
	 * Length = 0-20 characters and numbers.
	 * @param serviceId
	 * @return the current TravelTicket object
	 */
	public TravelTicket setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	
	/**
	 * 
	 * @return the ticketnumber
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * The carrier's ticket number.
	 * @param ticketNumber
	 * @return the current TravelTicket object
	 */
	public TravelTicket setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
		return this;
	}
	
	/**
	 * 
	 * @return if the ticket is refundable or not
	 */
	public boolean getRefundable() {
		return isRefundable;
	}
	
	/**
	 * Indicates whether or not this ticket is refundable.
	 * @param isRefundable
	 * @return the current TravelTicket object
	 */
	public TravelTicket setRefundable(boolean isRefundable) {
		this.isRefundable = isRefundable;
		return this;
	}
	
	/**
	 * 
	 * @return if the ticket is rebookable or not
	 */
	public boolean getRebookable() {
		return isRebookable;
	}
	
	/**
	 * Indicates whether or not this ticket is re-bookable.
	 * @param isRebookable
	 * @return the current TravelTicket object
	 */
	public TravelTicket setRebookable(boolean isRebookable) {
		this.isRebookable = isRebookable;
		return this;
	}
	
	/**
	 * 
	 * @return the passenger
	 */
	public TravelPassenger getPassenger() {
		return passenger;
	}
	
	/**
	 * The passenger traveling on this ticket.
	 * @param passenger
	 * @return the current TravelTicket object
	 */
	public TravelPassenger setPassenger(TravelPassenger passenger) {
		this.passenger = passenger;
		return this.passenger;
	}

}
