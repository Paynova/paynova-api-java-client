package com.paynova.api.client.integrationtest;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.model.CurrencyCode;
import com.paynova.api.client.model.InterfaceOptions;
import com.paynova.api.client.model.PaymentChannel;
import com.paynova.api.client.request.InitializePaymentRequest;
import com.paynova.api.client.response.CreateOrderResponse;
import com.paynova.api.client.response.InitializePaymentResponse;

public class InitializePaymentTest {
	private APICredentials apiC = null;
	private boolean forceLocalTests = false;
	
	@Test
	public void testInitializePaymentSuccess() {
		try{
			BigDecimal totalAmount = new BigDecimal(100.00);
			
			Map<String,String> mockValues1 = new HashMap<String,String>();
			mockValues1.put("MOCK_VALUE_ORDER_ID", UUID.randomUUID().toString());
			String mockResponse1 = TestHelper.getJsonResponse("response.createorder.success", mockValues1);
			PaynovaClient client1 = TestHelper.getPaynovaClient(
						mockResponse1,201,ExceptionEnum.NONE,apiC,forceLocalTests
					);
			
			CreateOrderResponse response = client1.createOrder("1234", totalAmount, CurrencyCode.SWEDISH_KRONA);
			
			
			InterfaceOptions interfaceOptions = new InterfaceOptions(
					InterfaceOptions.ID_AERO, 
					"SWE",
					new URL(TestHelper.getTestPropertyValue("paynova.api.successurl")),
					new URL(TestHelper.getTestPropertyValue("paynova.api.cancelurl")),
					new URL(TestHelper.getTestPropertyValue("paynova.api.pendingurl"))
					);
			InitializePaymentRequest request = new InitializePaymentRequest(response.getOrderId(),totalAmount,
					PaymentChannel.WEB,interfaceOptions);
			
			String mockResponse = TestHelper.getJsonResponse("response.initializepayment.success");
			PaynovaClient client = TestHelper.getPaynovaClient(
						mockResponse,201,ExceptionEnum.NONE,apiC,forceLocalTests
					);
			InitializePaymentResponse ipResponse = client.initializePayment(request);
			
			assertTrue(ipResponse.getStatus().getIsSuccess());
			assertTrue(ipResponse.getSessionId()!=null);
		}catch (PaynovaHttpException phe){
			assertTrue(false);
		}catch(MalformedURLException mue) {
			assertTrue(false);
			System.out.println(mue);
		}
	}
	
	@Test
	public void testInitializePaymentFailDueToBadOrderId() {
		try{
			BigDecimal totalAmount = new BigDecimal(100.00);
			UUID badOrderId = UUID.randomUUID();
			InterfaceOptions interfaceOptions = new InterfaceOptions(
					InterfaceOptions.ID_AERO, 
					"SWE",
					new URL(TestHelper.getTestPropertyValue("paynova.api.successurl")),
					new URL(TestHelper.getTestPropertyValue("paynova.api.cancelurl")),
					new URL(TestHelper.getTestPropertyValue("paynova.api.pendingurl"))
					);
			InitializePaymentRequest request = new InitializePaymentRequest(badOrderId,totalAmount,
					PaymentChannel.WEB,interfaceOptions);
			
			
			String mockResponse = TestHelper.getJsonResponse("response.initializepayment.fail");
			PaynovaClient client = TestHelper.getPaynovaClient(
						mockResponse,201,ExceptionEnum.NONE,apiC,forceLocalTests
					);
			
			client.initializePayment(request);
			
			assertTrue(false);
		}catch (PaynovaHttpException phe){
			assertTrue(phe.getStatus().getIsSuccess()==false);
		}catch(MalformedURLException mue) {
			assertTrue(false);
			System.out.println(mue);
		}
	}
	
}
