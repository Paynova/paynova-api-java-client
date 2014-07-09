package com.paynova.api.client.http;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;


public class HttpImplTest extends TestCase {
	
	private boolean forceLocalTests = true;
	

	
	@Test
	public void testSuccessfulGet() {
		try {
			String mockResponse = "SUCCESS";
			Integer responseCode = new Integer(200);
			
			Http http = TestHelper.getHttpImpl(mockResponse, responseCode, 
					ExceptionEnum.NONE, null,forceLocalTests);
			HttpEvent httpEvent = http.get("rest/path");
			
			assertEquals(responseCode, new Integer(httpEvent.getCode()));
			assertEquals(mockResponse, httpEvent.getResponseBody());
		
		} catch (PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGettUnkownHost(){
		try{
			String mockResponse = "SUCCESS";
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(
					mockResponse, 
					responseCode, 
					ExceptionEnum.UNKNOWN_HOST, 
					new APICredentials("http://www.reallynotfound.com","not", "important"),
					forceLocalTests
			);
						
			http.get("rest/path");
		}catch(PaynovaHttpException phe) {
			assertTrue(phe.getMessage().contains("UnknownHostException"));
		}
		
	}
	
	@Test  
	public void testGetExpectAPIStatusError(){
		try{
			String mockResponse = TestHelper.getJsonResponse("response.authentication.failed");
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(
					mockResponse, 
					responseCode, 
					ExceptionEnum.NONE, 
					null,
					forceLocalTests
			);
			http.get("rest/path");
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(phe.getStatus().getIsSuccess()==false);
			
		}
		
	}
	
	@Test
	public void testSuccessfulDelete() {
		try {
			String mockResponse = "SUCCESS";
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(mockResponse, responseCode, 
					ExceptionEnum.NONE, null,forceLocalTests);
						
			HttpEvent httpEvent = http.delete("rest/path");
			
			assertEquals(responseCode, new Integer(httpEvent.getCode()));
			assertEquals(mockResponse, httpEvent.getResponseBody());
		
		} catch (PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testDeleteUnkownHost(){
		try{
			String mockResponse = "SUCCESS";
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(
					mockResponse, 
					responseCode, 
					ExceptionEnum.UNKNOWN_HOST, 
					new APICredentials("http://www.reallynotfound.com","not", "important"),
					forceLocalTests
			);
						
			http.delete("rest/path");
		}catch(PaynovaHttpException phe) {
			assertTrue(phe.getMessage().contains("UnknownHostException"));
		}
		
	}
	
	@Test  
	public void testDeleteExpectAPIStatusError(){
		try{
			String mockResponse = TestHelper.getJsonResponse("response.authentication.failed");
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(
					mockResponse, 
					responseCode, 
					ExceptionEnum.NONE, 
					null,
					forceLocalTests
			);
						
			http.delete("rest/path");
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(phe.getStatus().getIsSuccess()==false);
			
		}
		
	}
	
	@Test
	public void testSuccessfulPost() {
		try {
			String mockResponse = "SUCCESS";
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(mockResponse, responseCode, 
					ExceptionEnum.NONE, null,forceLocalTests);
						
			HttpEvent httpEvent = http.post("rest/path","{\"foo\":\"foo\"}");
			
			assertEquals(responseCode, new Integer(httpEvent.getCode()));
			assertEquals(mockResponse, httpEvent.getResponseBody());
		
		} catch (PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testPostUnkownHost(){
		try{
			String mockResponse = "SUCCESS";
			Integer responseCode = new Integer(200);
			
			Http http = TestHelper.getHttpImpl(
					mockResponse, 
					responseCode, 
					ExceptionEnum.UNKNOWN_HOST, 
					new APICredentials("http://www.reallynotfound.com","not", "important"),
					forceLocalTests
			);
						
			http.post("rest/path","{\"foo\":\"foo\"}");
		}catch(PaynovaHttpException phe) {
			assertTrue(phe.getMessage().contains("UnknownHostException"));
		}
		
	}
	
	@Test  
	public void testPostExpectAPIStatusError(){
		try{
			String mockResponse = TestHelper.getJsonResponse("response.authentication.failed");
			Integer responseCode = new Integer(200);
			Http http = TestHelper.getHttpImpl(
					mockResponse, 
					responseCode, 
					ExceptionEnum.NONE, 
					null,
					forceLocalTests
			);
						
			http.post("rest/path","{foo:\"foo\"}");
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(phe.getStatus().getIsSuccess()==false);
			
		}
		
	}
	
}
