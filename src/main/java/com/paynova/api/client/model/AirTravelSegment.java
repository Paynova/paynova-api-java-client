package com.paynova.api.client.model;

import java.util.Arrays;

public class AirTravelSegment extends TravelSegment {

	private String departureAirportCode;
	
	private String arrivalAirportCode;
	
	/**
	 * Class constructor of this abstract class. Direct known subclasses to use is
	 * AirTravelSegment and RailTravelSegment
	 * @param departureDate	the scheduled departure date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param departureTime	the scheduled departure time for this segment, in the format HH:MM, 
	 * using the 24-hour time format. For example, "19:55".
	 * @param departureCountryCode	The country in which the departure airport for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param departureAirportCode the IATA or ICAO airport or city code of the departure airport for 
	 * this segment, in the format authority:code. For example, if you were sending the code for 
	 * Arlanda airport in Stockholm, Sweden, you would send:
	 * - For IATA you would send: "IATA:ARN"
	 * - For ICAO you would send: "ICAO:ESSA"
	 * @param arrivalDate	the scheduled arrival date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param arrivalTime	the scheduled arrival time for this segment, in the format HH:MM, using 
	 * the 24-hour time format. For example, "19:55".
	 * @param arrivalCountryCode	The country in which the destination airport for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param arrivalAirportCode	the IATA or ICAO airport or city code of the arrival airport for 
	 * this segment, in the format authority:code. For example, if you were sending the code for 
	 * Arlanda airport in Stockholm, Sweden, you would send:
	 * - For IATA you would send: "IATA:ARN"
	 * - For ICAO you would send: "ICAO:ESSA"
	 * @param carrierDesignator	the IATA or ICAO airline code Examples:
	 * - (AIR Segments) If you were sending the code for Scandinavian Airlines (SAS), you would send:
	 * - - For IATA you would send: "IATA:SK"
	 * - - For ICAO, you would send: "ICAO:SAS"
	 * - (RAIL Segments) If you were sending the code for Swedish Railway (SJ), you would send:
	 * - - For UIC you would send: "UIC:1174"
	 * @param tickets	the tickets which were issued for this segment of travel.
	 */
	public AirTravelSegment(String departureDate, String departureTime, String departureCountryCode, String departureAirportCode,
			String arrivalDate, String arrivalTime, String arrivalCountryCode, String arrivalAirportCode,
			String carrierDesignator, ApiPropertyList<TravelTicket> tickets) {
			super(
					TravelSegment.AIR,
					departureDate, 		departureTime, 	departureCountryCode,
					arrivalDate, 		arrivalTime, 	arrivalCountryCode,
					carrierDesignator, 	tickets
			);
			
			setDepartureAirportCode(departureAirportCode);
			setArrivalAirportCode(arrivalAirportCode);
	}
	
	/**
	 * Class constructor of this abstract class. Direct known subclasses to use is
	 * AirTravelSegment and RailTravelSegment
	 * @param departureDate	the scheduled departure date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param departureTime	the scheduled departure time for this segment, in the format HH:MM, 
	 * using the 24-hour time format. For example, "19:55".
	 * @param departureCountryCode	The country in which the departure airport for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param departureAirportCode the IATA or ICAO airport or city code of the departure airport for 
	 * this segment, in the format authority:code. For example, if you were sending the code for 
	 * Arlanda airport in Stockholm, Sweden, you would send:
	 * - For IATA you would send: "IATA:ARN"
	 * - For ICAO you would send: "ICAO:ESSA"
	 * @param arrivalDate	the scheduled arrival date for this segment, in the format YYYY-MM-DD. 
	 * For example, "2013-11-23".
	 * @param arrivalTime	the scheduled arrival time for this segment, in the format HH:MM, using 
	 * the 24-hour time format. For example, "19:55".
	 * @param arrivalCountryCode	The country in which the destination airport for this 
	 * segment is in. This may be the two-letter (alpha-2), three-letter (alpha-3) code or the ISO 
	 * country number as per ISO 3166-1. Examples "SE", "SWE", "752"
	 * @param arrivalAirportCode	the IATA or ICAO airport or city code of the arrival airport for 
	 * this segment, in the format authority:code. For example, if you were sending the code for 
	 * Arlanda airport in Stockholm, Sweden, you would send:
	 * - For IATA you would send: "IATA:ARN"
	 * - For ICAO you would send: "ICAO:ESSA"
	 * @param carrierDesignator	the IATA or ICAO airline code Examples:
	 * - (AIR Segments) If you were sending the code for Scandinavian Airlines (SAS), you would send:
	 * - - For IATA you would send: "IATA:SK"
	 * - - For ICAO, you would send: "ICAO:SAS"
	 * - (RAIL Segments) If you were sending the code for Swedish Railway (SJ), you would send:
	 * - - For UIC you would send: "UIC:1174"
	 * * @param ticket	a ticket which were issued for this segment of travel.
	 */
	public AirTravelSegment(String departureDate, String departureTime, String departureCountryCode,String departureAirportCode,
			String arrivalDate, String arrivalTime, String arrivalCountryCode, String arrivalAirportCode,
			String carrierDesignator,TravelTicket ticket) {
			this( 	departureDate,  	departureTime,  departureCountryCode, 	departureAirportCode,
					arrivalDate,  		arrivalTime,  	arrivalCountryCode,  	arrivalAirportCode,
					carrierDesignator, 	new ApiPropertyList<TravelTicket> (Arrays.asList(new TravelTicket[]{ticket})));
	}
	
	/**
	 * 
	 * @return the departure airport code
	 */
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	
	/**
	 * The IATA or ICAO airport or city code of the departure airport for 
	 * this segment, in the format authority:code. For example, if you were sending the code for 
	 * Arlanda airport in Stockholm, Sweden, you would send:
	 * - For IATA you would send: "IATA:ARN"
	 * - For ICAO you would send: "ICAO:ESSA"
	 * @param departureAirportCode
	 * @return	the current AirTravelSegment object
	 */
	public AirTravelSegment setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
		return this;
	}
	
	/**
	 * 
	 * @return	the arrival airport code
	 */
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}
	
	/**
	 * The IATA or ICAO airport or city code of the arrival airport for 
	 * this segment, in the format authority:code. For example, if you were sending the code for 
	 * Arlanda airport in Stockholm, Sweden, you would send:
	 * - For IATA you would send: "IATA:ARN"
	 * - For ICAO you would send: "ICAO:ESSA"
	 * @param arrivalAirportCode
	 * @return	the current AirTravelSegment object
	 */
	public AirTravelSegment setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
		return this;
	}

	
}
