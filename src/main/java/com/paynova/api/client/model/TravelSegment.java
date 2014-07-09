package com.paynova.api.client.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TravelSegment extends ApiPropertyContainer{
	
	protected static final String AIR = "AIR";
	protected static final String RAIL = "RAIL";
	
	private String segmentType;
	
	private String departureDate;
	
	private String departureTime;
	
	private String departureCountryCode;
	
	private String arrivalDate;
	
	private String arrivalTime;
	
	private String arrivalCountryCode;
	
	private String carrierDesignator;
	
	private ApiPropertyList<TravelTicket> tickets = new ApiPropertyList<TravelTicket>();
	
	/**
	 * Class constructor of this abstract class. Direct known subclasses to use is
	 * AirTravelSegment and RailTravelSegment
	 * @param segmentType	the means of travel. The possible values RAIL, AIR
	 * @param departureDate	the scheduled departure date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param departureTime	the scheduled departure time for this segment, in the format HH:MM, 
	 * using the 24-hour time format. For example, "19:55".
	 * @param departureCountryCode	The country in which the departure station/airport for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param arrivalDate	the scheduled arrival date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param arrivalTime	the scheduled arrival time for this segment, in the format HH:MM, using 
	 * the 24-hour time format. For example, "19:55".
	 * @param arrivalCountryCode	The country in which the destination station/airport for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param carrierDesignator	the IATA or ICAO airline code, or the UIC railway code, of the 
	 * carrier for this segment, in the format <authority>:<code>. Examples:
	 * - (AIR Segments) If you were sending the code for Scandinavian Airlines (SAS), you would send:
	 * - - For IATA you would send: "IATA:SK"
	 * - - For ICAO, you would send: "ICAO:SAS"
	 * - (RAIL Segments) If you were sending the code for Swedish Railway (SJ), you would send:
	 * - - For UIC you would send: "UIC:1174"
	 * @param tickets	the tickets which were issued for this segment of travel.
	 */
	protected TravelSegment(String segmentType,String departureDate, String departureTime, String departureCountryCode,
			String arrivalDate, String arrivalTime, String arrivalCountryCode,
			String carrierDesignator, ApiPropertyList<TravelTicket> tickets) {
		this.segmentType = segmentType;
		this.setDepartureDate(departureDate);
		this.setDepartureTime(departureTime);
		this.setDepartureCountryCode(departureCountryCode);
		
		this.setArrivalCountryCode(arrivalCountryCode);
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);
		this.setArrivalCountryCode(arrivalCountryCode);
		this.setCarrierDesignator(carrierDesignator);
		this.setTickets(tickets);
	
	}
	
	/**
	 * 
	 * @return the segment type of this TravelSegment
	 */
	public String getSegmentType() {
		return segmentType;
	}
	
	/**
	 * 
	 * @return the departure date
	 */
	public String getDepartureDate() {
		return departureDate;
	}
	
	/**
	 * The scheduled departure date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param departureDate
	 * @return the current TravelSegment object
	 */
	public TravelSegment setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
		return this;
	}
	
	/**
	 * 
	 * @return the departure time of this TravelSegment
	 */
	public String getDepartureTime() {
		return departureTime;
	}
	
	/**
	 * The scheduled departure date and time for this segment.
	 * @param dateTime	 Date-object containing the departure DateTime
	 * @return the current TravelSegment object
	 */
	public TravelSegment setDepartureDateTime(Date dateTime) {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		departureDate = date.format(dateTime);
		
		DateFormat time = new SimpleDateFormat("HH:mm");
		departureTime = time.format(dateTime);
		return this;
	}
	
	/**
	 * The scheduled departure time for this segment, in the format 
	 * HH:MM, using the 24-hour time format. For example, "19:55".
	 * @param departureTime the time of departure
	 * @return the current TravelSegment object
	 */
	public TravelSegment setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
		return this;
	}
	
	/**
	 * 
	 * @return the country code
	 */
	public String getDepartureCountryCode() {
		return departureCountryCode;
	}

	/**
	 * The country in which the departure station/airport for this segment is in. 
	 * This may be the two-letter (alpha-2), three-letter (alpha-3) code or the 
	 * ISO country number as per ISO 3166-1. Example values: "SE", "SWE", "752".
	 * @param departureCountryCode
	 * @return the current TravelSegment object
	 */
	public TravelSegment setDepartureCountryCode(String departureCountryCode) {
		this.departureCountryCode = departureCountryCode;
		return this;
	}
	
	/**
	 * 
	 * @return the arrival date
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * The scheduled arrival date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param arrivalDate
	 * @return the current TravelSegment object
	 */
	public TravelSegment setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
		return this;
	}
	
	/**
	 * The scheduled arrival date and time for this segment.
	 * @param dateTime	 Date-object containing the arrival date and time
	 * @return the current TravelSegment object
	 */
	public TravelSegment setArrivalDateTime(Date dateTime) {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		arrivalDate = date.format(dateTime);
		
		DateFormat time = new SimpleDateFormat("HH:mm");
		arrivalTime = time.format(dateTime);
		return this;
	}
	
	/**
	 * 
	 * @return	the arrival time
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * The scheduled arrival time for this segment, in the format HH:MM, using the 
	 * 24-hour time format. For example, "19:55".
	 * @param arrivalTime
	 * @return the current TravelSegment object
	 */
	public TravelSegment setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
		return this;
	}
	
	/**
	 * 
	 * @return the arrival country code
	 */
	public String getArrivalCountryCode() {
		return arrivalCountryCode;
	}
	
	/**
	 * The country in which the destination station/airport for this segment is in. 
	 * This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Example values: "SE", "SWE", "752".
	 * @param arrivalCountryCode
	 * @return the current TravelSegment object
	 */
	public TravelSegment setArrivalCountryCode(String arrivalCountryCode) {
		this.arrivalCountryCode = arrivalCountryCode;
		return this;
	}
	/**
	 * 
	 * @return the carrier designator
	 */
	public String getCarrierDesignator() {
		return carrierDesignator;
	}
	
	/**
	 * CarrierDesignator the IATA or ICAO airline code, or the UIC railway code, of the 
	 * carrier for this segment, in the format <authority>:<code>. Examples:
	 * - (AIR Segments) If you were sending the code for Scandinavian Airlines (SAS), you would send:
	 * - - For IATA you would send: "IATA:SK"
	 * - - For ICAO, you would send: "ICAO:SAS"
	 * - (RAIL Segments) If you were sending the code for Swedish Railway (SJ), you would send:
	 * - - For UIC you would send: "UIC:1174"
	 * @param carrierDesignator
	 * @return the current TravelSegment object 
	 */
	public TravelSegment setCarrierDesignator(String carrierDesignator) {
		this.carrierDesignator = carrierDesignator;
		return this;
	}
	
	
	/**
	 * 
	 * @return the list of tickets
	 */
	public ApiPropertyList<TravelTicket> getTickets() {
		return tickets;
	}
	
	/**
	 * The tickets which were issued for this segment of travel.
	 * @param tickets
	 * @return the current TravelSegment object
	 */
	public ApiPropertyList<TravelTicket> setTickets(ApiPropertyList<TravelTicket> tickets) {
		this.tickets = tickets;
		return this.tickets;
	}
	
	/**
	 * Add a Ticket 
	 * @param ticket
	 * @return the list of Ticket's
	 */
	public  ApiPropertyList<TravelTicket> addTicket(TravelTicket ticket) {
		tickets.add(ticket);
		return tickets;
	}
	
	/**
	 * Get a Ticket stored in the Ticket list
	 * @param index of the Ticket to get
	 * @return the Ticket at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public  TravelTicket getTicketAtIndex(int index) {
		return tickets.get(index);
	}
	
	/**
	 * Remove a Ticket stored in the Ticket list
	 * @param index of the Ticket to get
	 * @return the (just removed) Ticket at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public  TravelTicket removeTicketAtIndex(int index) {
		return tickets.remove(index);
	}
}
