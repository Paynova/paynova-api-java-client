package com.paynova.api.client.model;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestTravelSegment {

	@Test
	public void testSetDepartureDateTime() {
		TravelPassenger passenger = new TravelPassenger();
		TravelTicket ticket = new TravelTicket(true,true,passenger);
		
		AirTravelSegment ats = new AirTravelSegment("2014-07-01", "18:00", "SE", "IATA:ARN", 
				"2014-07-01", "21:00", "SE", "IATA:MMA", "IATA:SK", ticket);
		
		assertEquals("2014-07-01", ats.getDepartureDate());
		assertEquals("18:00", ats.getDepartureTime());
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2014-07-01 19:00");
			ats.setDepartureDateTime(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("2014-07-01", ats.getDepartureDate());
		assertEquals("19:00", ats.getDepartureTime());
	}

}
