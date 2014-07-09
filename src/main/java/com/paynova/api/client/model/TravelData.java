package com.paynova.api.client.model;

public class TravelData  extends ApiPropertyContainer {
	private String bookingReference;
	
	private ApiPropertyList<TravelSegment> travelSegments;
	
	/**
	 * Class constructor
	 * @param bookingReference	the booking reference number for the entire booking.
	 * @param travelSegments	the travel segments which are included in this booking.
	 */
	public TravelData(String bookingReference, ApiPropertyList<TravelSegment> travelSegments) {
		this.bookingReference = bookingReference;
		this.travelSegments = travelSegments;
	}
	
	/**
	 * 
	 * @return the booking reference of this TravelData
	 */
	public String getBookingReference() {
		return bookingReference;
	}

	/**
	 * 
	 * @param bookingReference
	 * @return the current TravelData object
	 */
	public TravelData setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
		return this;
	}
	
	/**
	 * 
	 * @return the travel segments of this Travel Data
	 */
	public ApiPropertyList<TravelSegment> getTravelSegments() {
		return travelSegments;
	}
	
	/**
	 * The travel segments which are included in this booking.
	 * @param travelSegments
	 * @return the ApiPropertyList<TravelSegment> list of TravelSegment's
	 */
	public ApiPropertyList<TravelSegment> setTravelSegments(ApiPropertyList<TravelSegment> travelSegments) {
		this.travelSegments = travelSegments;
		return this.travelSegments;
	}
	
	/**
	 * Add a TravelSegment
	 * @param travelSegment
	 * @return the list of TravelSegment's
	 * @see {@link #setTravelSegments(ApiPropertyList) setTravelSegments}
	 */
	public ApiPropertyList<TravelSegment> addTravelSegment(TravelSegment travelSegment) {
		travelSegments.add(travelSegment);
		return travelSegments;
	}
	
	/**
	 * Get a TravelSegment stored in the travelSegment list
	 * @param index of the TravelSegment method to get
	 * @return the TravelSegment at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public TravelSegment getTravelSegmentIndex(int index) {
		return travelSegments.get(index);
	}
	
	/**
	 * Remove a TravelSegment stored in the travelSegment list
	 * @param index of the TravelSegment method to get
	 * @return the (just removed) TravelSegment at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public TravelSegment removeTravelSegmentAtIndex(int index) {
		return travelSegments.remove(index);
	}

}
