package com.paynova.api.client.integrationtest;

import java.util.UUID;

import junit.framework.TestCase;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.request.RemoveCustomerProfileCardRequest;

public class RemoveCustomerProfileCardTest extends TestCase{

	private boolean forceLocalTests = true;
	
	private APICredentials apiC = null;
	
	public void testRemoveCustomerProfileCardExpectSuccess() {
		String profileId = "a-customer-123";
		UUID cardId = UUID.fromString("7cfb4a9d-16ae-490f-be85-a35d01627261");
		
		
		String mockResponse = TestHelper.getJsonResponse("response.removecustomerprofilecard.success");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		
		RemoveCustomerProfileCardRequest request = new RemoveCustomerProfileCardRequest(profileId, cardId);
		try{
			client.removeCustomerProfileCard(request);//No response type - will throw exception if fail
			assertTrue(true);
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	public void testRemoveCustomerProfileCardExpectFailureDueToNoneExistingCardId() {
		String profileId = "a-customer-123";
		UUID cardId = UUID.fromString("7cfb4a9d-16ae-490f-be85-a35d01627261");
		
		
		String mockResponse = TestHelper.getJsonResponse("response.removecustomerprofilecard.fail");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		
		RemoveCustomerProfileCardRequest request = new RemoveCustomerProfileCardRequest(profileId, cardId);
		try{
			client.removeCustomerProfileCard(request);//No response type - will throw exception if fail
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(!phe.getStatus().getIsSuccess());
		}
	}

}
