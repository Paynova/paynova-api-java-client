package com.paynova.api.client;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.Properties;

import com.paynova.api.client.http.Http;
import com.paynova.api.client.http.HttpImpl;
import com.paynova.api.client.http.HttpURLConnectionMock;
import com.paynova.api.client.util.PropertyFileReader;

public class TestHelper {
	
	private static Properties testProperties;
	
	private static APICredentials credentials;
	
	private TestHelper() {}
	
	public static String getTestPropertyValue(String key) {
		if(testProperties == null) {
			testProperties = PropertyFileReader.getPropertiesFromFile("./","paynova-test.properties");
		}
		return testProperties.getProperty(key);
	}
	
	public static APICredentials getAPICredentials() {
		if(credentials == null) {
			credentials = new APICredentials(
					getTestPropertyValue("paynova.api.endpoint"), 
					getTestPropertyValue("paynova.api.username"), 
					getTestPropertyValue("paynova.api.password")
			);
		}
		return credentials;
	}
	
	public static PaynovaClient getPaynovaClient(String mockResponse,int responseCode, 
			ExceptionEnum exceptionToThrow, APICredentials apiC, boolean forceLocalTests){
		return new PaynovaClientImpl( 
					getHttpImpl(mockResponse,responseCode, exceptionToThrow, apiC, forceLocalTests)
					);
	}
	
	public static Http getHttpImpl(String mockResponse,int responseCode, ExceptionEnum exceptionToThrow, 
			APICredentials apiC, boolean forceLocalTests) {
		Http http = null;
		if(apiC==null)apiC = getAPICredentials();
		if(getTestPropertyValue("paynova.do.live.test").equals("true") && !forceLocalTests) {
			http = new HttpImpl(apiC);
		}else {
			try{
				http = new HttpImpl(
						apiC,
						new HttpURLConnectionMock(
								apiC.getEndpointURL().toString(),
								mockResponse,
								responseCode,
								exceptionToThrow
						)
				);
			}catch(MalformedURLException mue){
				System.out.println(mue);
			}
		}
		return http;
	}
	/**
	 * 
	 * 
	 * @param responseType example response.createorder.success, response.createorder.error.typeoferror
	 * @param mockValues key/value list that will be use to replace MOCK_VALUE_ORDER_ID
	 * @return
	 */
	public static String getJsonResponse(String responseType, Map<String, String> mockValues) {
		StringBuilder json = new StringBuilder(getTestPropertyValue(responseType));
		if(mockValues != null) {
			for (Map.Entry<String, String> entry : mockValues.entrySet()) {
				String key = entry.getKey();
				int index = json.indexOf(key);
				if(index>=0) {
					json.replace(index, index+key.length(), entry.getValue());
				}
			}
		}
		return json.toString();
	}

	public static String getJsonResponse(String responseType) {
		return getJsonResponse(responseType, null);
	}
}