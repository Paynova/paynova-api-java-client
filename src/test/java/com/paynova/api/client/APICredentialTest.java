package com.paynova.api.client;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.org.apache.commons.codec.binary.Base64;

public class APICredentialTest  extends TestCase {
	
	@Test
	public void testGetBasicAuthStringBase64Encoded() {
		APICredentials c = new APICredentials("http://endpoint.com", "username", "password");
		
		String b64 =  "Basic " + Base64.encodeBase64String((c.getUsername() + ":" + c.getPassword()).getBytes()).trim();
		
		assertEquals(c.getBasicAuthStringBase64Encoded(), b64);
	}
}
