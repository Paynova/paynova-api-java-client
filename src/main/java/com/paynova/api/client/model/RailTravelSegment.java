package com.paynova.api.client.model;

import java.util.Arrays;

public class RailTravelSegment extends TravelSegment {

	private String departureStationCode;
	
	private String arrivalStationCode;
	
	/**
	 * Class constructor of this abstract class. Direct known subclasses to use is
	 * RailTravelSegment and RailTravelSegment
	 * @param departureDate	the scheduled departure date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param departureTime	the scheduled departure time for this segment, in the format HH:MM, 
	 * using the 24-hour time format. For example, "19:55".
	 * @param departureCountryCode	The country in which the departure station for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param departureStationCode	the identifier for the rail station which this segment is departing from.
	 * @param arrivalDate	the scheduled arrival date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param arrivalTime	the scheduled arrival time for this segment, in the format HH:MM, using 
	 * the 24-hour time format. For example, "19:55".
	 * @param arrivalCountryCode	The country in which the destination station for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param arrivalStationCode	the identifier for the arrival rail station of this segment.
	 * @param carrierDesignator	the UIC railway code, of the carrier for this segment, in the format 
	 * authority:code Examples:
	 * - If you were sending the code for Swedish Railway (SJ), you would send:
	 * - - For UIC you would send: "UIC:1174"
	 * @param tickets	the tickets which were issued for this segment of travel.
	 */
	public RailTravelSegment(String departureDate, String departureTime, String departureCountryCode, String departureStationCode,
			String arrivalDate, String arrivalTime, String arrivalCountryCode, String arrivalStationCode,
			String carrierDesignator, ApiPropertyList<TravelTicket> tickets) {
			super(
					TravelSegment.RAIL,
					departureDate, 		departureTime, 	departureCountryCode,
					arrivalDate, 		arrivalTime, 	arrivalCountryCode,
					carrierDesignator, 	tickets
			);
			
			setDepartureStationCode(departureStationCode);
			setArrivalStationCode(arrivalStationCode);
	}
	
	/**
	 * Class constructor of this abstract class. Direct known subclasses to use is
	 * RailTravelSegment and RailTravelSegment
	 * @param departureDate	the scheduled departure date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param departureTime	the scheduled departure time for this segment, in the format HH:MM, 
	 * using the 24-hour time format. For example, "19:55".
	 * @param departureCountryCode	The country in which the departure station for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param departureStationCode	the identifier for the rail station which this segment is departing from.
	 * @param arrivalDate	the scheduled arrival date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param arrivalTime	the scheduled arrival time for this segment, in the format HH:MM, using 
	 * the 24-hour time format. For example, "19:55".
	 * @param arrivalCountryCode	The country in which the destination station for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param arrivalStationCode	the identifier for the arrival rail station of this segment.
	 * @param carrierDesignator	the UIC railway code, of the carrier for this segment, in the format 
	 * authority:code Examples:
	 * - If you were sending the code for Swedish Railway (SJ), you would send:
	 * - - For UIC you would send: "UIC:1174"
	 * @param ticket	a ticket which were issued for this segment of travel.
	 */
	public RailTravelSegment(String departureDate, String departureTime, String departureCountryCode,String departureStationCode,
			String arrivalDate, String arrivalTime, String arrivalCountryCode, String arrivalStationCode,
			String carrierDesignator,TravelTicket ticket) {
			this( 	departureDate,  	departureTime,  departureCountryCode, 	departureStationCode,
					arrivalDate,  		arrivalTime,  	arrivalCountryCode,  	arrivalStationCode,
					carrierDesignator, 	new ApiPropertyList<TravelTicket> (Arrays.asList(new TravelTicket[]{ticket})));
	}
	
	/**
	 * 
	 * @return the departure station code
	 */
	public String getDepartureStationCode() {
		return departureStationCode;
	}
	
	/**
	 * The identifier for the rail station which this segment is departing from.
	 * @param departureStationCode
	 * @return the current RailTravelSegment object
	 */
	public RailTravelSegment setDepartureStationCode(String departureStationCode) {
		this.departureStationCode = departureStationCode;
		return this;
	}
	
	/**
	 * 
	 * @return the arrival station code
	 */
	public String getArrivalStationCode() {
		return arrivalStationCode;
	}

	/**
	 * The identifier for the arrival rail station of this segment.
	 * @param arrivalStationCode
	 * @return the current RailTravelSegment object
	 */
	public RailTravelSegment setArrivalStationCode(String arrivalStationCode) {
		this.arrivalStationCode = arrivalStationCode;
		return this;
	}

	
}
