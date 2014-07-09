package com.paynova.api.client.integrationtest;

import junit.framework.TestCase;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.request.RemoveCustomerProfileRequest;

public class RemoveCustomerProfileTest extends TestCase{
	
	private boolean forceLocalTests = true;
	
	private APICredentials apiC = null;
	 
	public void testRemoveCustomerProfileExpectSuccess(){
		String profileId = "a-customer-123";
		String mockResponse = TestHelper.getJsonResponse("response.removecustomerprofile.success");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		RemoveCustomerProfileRequest request = new RemoveCustomerProfileRequest(profileId);
		try{
			client.removeCustomerProfile(request);//No response type - will throw exception on fail
			assertTrue(true);
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	public void testRemoveCustomerProfileExpectFailureDueToBadProfileId(){
		String profileId = "a-customer-123";
		String mockResponse = TestHelper.getJsonResponse("response.removecustomerprofile.fail");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		RemoveCustomerProfileRequest request = new RemoveCustomerProfileRequest(profileId);
		try{
			client.removeCustomerProfile(request);//No response type - will throw exception on fail
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(!phe.getStatus().getIsSuccess());
		}
	}
	
}
