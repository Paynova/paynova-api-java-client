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
import com.paynova.api.client.request.FinalizeAuthorizationRequest;
import com.paynova.api.client.response.FinalizeAuthorizationResponse;

public class FinalizeAuthorizationTest extends TestCase{
	
	private boolean forceLocalTests = true;
	
	private APICredentials apiC = null;
	
	@Test
	public void testFinalizeAuthorizationExpectSUCCESS() {
		UUID orderId = UUID.fromString("784cd901-da02-44ff-a043-a35b00fa6ea7");
		String transactionId = "201407011711571305";
		BigDecimal amount =  new BigDecimal(100.00);
		
		PaynovaClient client = getPaynovaClientForFinalizeAuthTests(amount, transactionId,"response.finalizeauthorization.success");
		
		try{
			FinalizeAuthorizationRequest request = new FinalizeAuthorizationRequest(
					orderId, transactionId, amount
			);
			FinalizeAuthorizationResponse response = client.finalizeAuthorization(request);
			
			assertTrue(response.getStatus().getIsSuccess());
			assertEquals(response.getTotalAmountFinalized(),amount);
			assertEquals(response.getTransactionId(),transactionId);
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFinalizeAuthorizationExpectFailDueToAlreadyFinalized() {
		UUID orderId = UUID.fromString("784cd901-da02-44ff-a043-a35b00fa6ea7");
		String transactionId = "201407011711571305";
		BigDecimal amount =  new BigDecimal(100.00);
		
		PaynovaClient client = getPaynovaClientForFinalizeAuthTests(amount, transactionId,"response.finalizeauthorization.fail");
		
		try{
			FinalizeAuthorizationRequest request = new FinalizeAuthorizationRequest(
					orderId, transactionId, amount
			);
			client.finalizeAuthorization(request);
			assertTrue(false);
			
		}catch(PaynovaHttpException phe) {
			assertTrue(!phe.getStatus().getIsSuccess());
		}
	}
	
	public PaynovaClient getPaynovaClientForFinalizeAuthTests(BigDecimal amount, String transactionId, String propertyKey) {
		Map<String,String> mockValues = new HashMap<String,String>();
		mockValues.put("MOCK_VALUE_AMOUNT_FINALIZED", amount.toString());
		mockValues.put("MOCK_VALUE_TRANSACTION_ID", transactionId);
		
		String mockResponse = TestHelper.getJsonResponse(propertyKey, mockValues);
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 200, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		return client;
	}

}
