package com.paynova.api.client.integrationtest;

import java.math.BigDecimal;
import java.util.UUID;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.request.AnnulAuthorizationRequest;

public class AnnulAuthorizationTest extends TestCase{
	
	private boolean forceLocalTests = true;
	
	private APICredentials apiC = null;
	
	@Test
	public void testAnnulAuthorizationExpectSuccess(){
		UUID orderId = UUID.fromString("748444f5-0ab4-469b-9a12-d94da27f0668");
		String transactionId = "201407011743371406";
		BigDecimal totalAmount = new BigDecimal(100.00);
		
		String mockResponse = TestHelper.getJsonResponse("response.annulauthorization.success");
		
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests);
		AnnulAuthorizationRequest request = new AnnulAuthorizationRequest(orderId,transactionId,totalAmount);
		try{
			client.annulAuthorization(request);
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testAnnulAuthorizationExpectFailureDueToAlreadyCanceled(){
		UUID orderId = UUID.fromString("748444f5-0ab4-469b-9a12-d94da27f0668");
		String transactionId = "201407011743371406";
		BigDecimal totalAmount = new BigDecimal(100.00);
		
		String mockResponse = TestHelper.getJsonResponse("response.annulauthorization.fail");
		
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests);
		AnnulAuthorizationRequest request = new AnnulAuthorizationRequest(orderId,transactionId,totalAmount);
		try{
			client.annulAuthorization(request);
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(!phe.getStatus().getIsSuccess());
		}
		
	}
}
