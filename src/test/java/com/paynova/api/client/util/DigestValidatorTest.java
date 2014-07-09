package com.paynova.api.client.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.paynova.api.client.TestHelper;

import junit.framework.TestCase;

public class DigestValidatorTest extends TestCase{
	 
	public void testVerify_POST_REDIRECT_DIGEST() {
		Map<String, String> postParameters = propertiesToMap(
				PropertyFileReader.getPropertiesFromFile("","post-redirect-parameters-sample.properties")
		);
		String secretKey = TestHelper.getTestPropertyValue("paynova.api.secretkey");
		assertTrue(DigestValidator.verify_POST_REDIRECT_DIGEST(postParameters, secretKey));
	}
	
	public void testVerify_EVENT_HOOK_BODY_DIGEST() {
		Map<String, String> postParameters = propertiesToMap(
				PropertyFileReader.getPropertiesFromFile("","event-hook-notification-parameters-sample.properties")
		);
		String secretKey = TestHelper.getTestPropertyValue("paynova.api.secretkey");
		assertTrue(DigestValidator.verify_EVENT_HOOK_BODY_DIGEST(postParameters, secretKey));
	}
	public void testVerify_EVENT_HOOK_HEADER_DIGEST(){
		Properties properties = PropertyFileReader.getPropertiesFromFile(
				"","event-hook-notification-verify-header-digest-sample-data.properties");
		String secretKey = TestHelper.getTestPropertyValue("paynova.api.secretkey");
		String pnDigest = properties.getProperty("header.key.pn-digest");
		String rawPOSTdata = properties.getProperty("raw.post.data");
		assertTrue(DigestValidator.verify_EVENT_HOOK_HEADER_DIGEST(secretKey, pnDigest, rawPOSTdata));
	}
	
	private static Map<String, String> propertiesToMap(Properties properties) {
		Map<String, String> map = new HashMap<String, String>();
		for (String key : properties.stringPropertyNames()) {
		    String value = properties.getProperty(key);
		    map.put(key, value);
		}
		return map;
	}
}
