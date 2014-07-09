package com.paynova.api.client.integrationtest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.model.Address;
import com.paynova.api.client.model.AirTravelSegment;
import com.paynova.api.client.model.ApiPropertyList;
import com.paynova.api.client.model.CompanyOrPersonName;
import com.paynova.api.client.model.CurrencyCode;
import com.paynova.api.client.model.Customer;
import com.paynova.api.client.model.LineItem;
import com.paynova.api.client.model.NameAndAddress;
import com.paynova.api.client.model.TravelData;
import com.paynova.api.client.model.TravelPassenger;
import com.paynova.api.client.model.TravelSegment;
import com.paynova.api.client.model.TravelTicket;
import com.paynova.api.client.request.CreateOrderRequest;
import com.paynova.api.client.response.CreateOrderResponse;

public class CreateOrderTest extends TestCase {
	
	private APICredentials apiC = null;
	private boolean forceLocalTests = false;
	
	@Test
	public void testCreateSimpleOrderExpectSuccess() {
		CreateOrderRequest request = new CreateOrderRequest("1234",new BigDecimal(100.00),CurrencyCode.SWEDISH_KRONA);
		
		Map<String,String> mockValues = new HashMap<String,String>();
		mockValues.put("MOCK_VALUE_ORDER_ID", UUID.randomUUID().toString());
		String mockResponse = TestHelper.getJsonResponse("response.createorder.success", mockValues);
		PaynovaClient client = TestHelper.getPaynovaClient(
					mockResponse,201,ExceptionEnum.NONE,apiC,forceLocalTests
				);
		try{
			CreateOrderResponse response = client.createOrder(request);
			assertTrue(response.getStatus().getIsSuccess());
			assertEquals(new Integer(response.getHttpEvent().getCode()),new Integer(201));
		} catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testCreateSimpleOrderExpectFailDueToBadOrderNumber() {
		CreateOrderRequest request = new CreateOrderRequest("123",new BigDecimal(100.00),CurrencyCode.SWEDISH_KRONA);
		
		String mockResponse = TestHelper.getJsonResponse("response.createorder.fail");
		PaynovaClient client = TestHelper.getPaynovaClient(
					mockResponse,201,ExceptionEnum.NONE,apiC,forceLocalTests
				);
		try{
			client.createOrder(request);
			assertTrue(false);
			
		} catch(PaynovaHttpException phe) {
			assertTrue(phe.getStatus().getIsSuccess()==false);
		}
		
	}
	
	@Test
	public void testCreateDetailedOrder() {
		
		CompanyOrPersonName name = new CompanyOrPersonName();
		name.setCompanyName("Foo company").
			setTitle("Foo Title").
			setFirstName("Foo").
			setMiddleNames("Foo-middle-name1, Foo-middle-name2").
			setLastName("Foo").
			setSuffix("King");
		
		Address address = new Address();
			address.setStreet1("Foostree1").
			setStreet2("Foostreet 2").
			setStreet3("Foostreet 3").
			setStreet4("Foostreet 4").
			setCity("Foocity").
			setRegionCode("Foo region").
			setCountryCode("SE");
		NameAndAddress nameAddress = new NameAndAddress();
			nameAddress.setName(name).
			setAddress(address);
		
		
		ApiPropertyList<TravelSegment> travelSegments = new ApiPropertyList<TravelSegment>();
		
		TravelPassenger passenger = new TravelPassenger();
		TravelTicket ticket = new TravelTicket(true,true,passenger);
		
		AirTravelSegment ats = new AirTravelSegment("2014-07-01", "18:00", "SE", "IATA:ARN", 
				"2014-07-01", "21:00", "SE", "IATA:MMA", "IATA:SK", ticket);
		travelSegments.add(ats);
		TravelData travelData = new TravelData("134-booking-ref",travelSegments);
			
			
		LineItem lineItem = new LineItem(
				"foo-123", "foo-nr-123", "FooItem", 1, 
				"st", new BigDecimal(100), 25, new BigDecimal(25), new BigDecimal(125)
				);
		lineItem.setDescription("Foo description");
		lineItem.setTravelData(travelData);
		
		
		CreateOrderRequest request = new CreateOrderRequest("1234", new BigDecimal(125.00), CurrencyCode.SWEDISH_KRONA);
		request.setSalesChannel("Foo sales channel").
			setSalesLocationId("My foo channel id").
			setCustomer(new Customer()).
				setCustomerId("customer-foo-111").
				setEmailAddress("foo@foo.com").
				setName(name);
		
				request.getCustomer().setHomeTelephone("+46 8 123456").
				setWorkTelephone("+46 8 123456").
				setMobileTelephone("+46 8 123456");
			request.setBillTo(nameAddress);
			request.setShipTo(nameAddress);
			request.addLineItem(lineItem);
		
			
			
		Map<String,String> mockValues = new HashMap<String,String>();
		UUID randomOrderId = UUID.randomUUID();
		mockValues.put("MOCK_VALUE_ORDER_ID", randomOrderId.toString());
		String mockResponse = TestHelper.getJsonResponse("response.createorder.success", mockValues);
		PaynovaClient client = TestHelper.getPaynovaClient(
					mockResponse,201,ExceptionEnum.NONE,apiC,forceLocalTests
				);	
		
		
		try{
			CreateOrderResponse response = client.createOrder(request);
			assertTrue(response.getStatus().getIsSuccess());
			assertTrue(response.getOrderId()!=null);
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
}
