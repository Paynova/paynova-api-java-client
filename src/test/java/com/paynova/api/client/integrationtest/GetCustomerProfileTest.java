package com.paynova.api.client.integrationtest;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.request.GetCustomerProfileRequest;
import com.paynova.api.client.response.GetCustomerProfileResponse;

public class GetCustomerProfileTest extends TestCase{
	
	private boolean forceLocalTests = true;
	
	private APICredentials apiC = null;
	
	@Test
	public void testGetCustomerProfileExpectSuccess() {
		String profileId = "nice-profile";
		
		String mockResponse = TestHelper.getJsonResponse("response.getcustomerprofile.success");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests);
		
		try{
			GetCustomerProfileRequest request = new GetCustomerProfileRequest(profileId);
			GetCustomerProfileResponse response = client.getCustomerProfile(request);
			assertEquals(response.getProfileId(),profileId);
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testGetCustomerProfileExpectFailureDueToNonExistingProfile() {
		String profileId = "asfsdfsdf";
		
		String mockResponse = TestHelper.getJsonResponse("response.getcustomerprofile.fail");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests);
		
		try{
			GetCustomerProfileRequest request = new GetCustomerProfileRequest(profileId);
			client.getCustomerProfile(request);
			
		}catch(PaynovaHttpException phe) {
			assertTrue(!phe.getStatus().getIsSuccess());
			assertNotNull(phe.getStatus().getStatusMessage());
		}
	}
}
