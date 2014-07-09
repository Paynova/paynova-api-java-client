package com.paynova.api.client.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.model.StatusWrapper;
import com.paynova.api.client.util.JsonParser;
import com.paynova.api.client.util.JsonParserImpl;
import com.paynova.api.client.util.Version;

public class HttpImpl implements Http {
	
	private APICredentials credentials;
	
	private HttpURLConnection httpURLConnection;
	
	enum RestMethod {
        DELETE, GET, POST;
    }
	
	/**
	 * Class constructor
	 * Constructs a HttpImpl
	 * @param credentials used for authentication
	 */
	public HttpImpl(APICredentials credentials) {
		this.credentials = credentials;
	}
	
	/**
	 * Class constructor, advanced do not use this constructor if you not are sure.
	 * Use HttpImpl(APICredentials credentials) instead
	 * Constructs a HttpImpl
	 * @param credentials used for authentication
	 * @param httpURLConnection that will be used to read/write on
	 */
	public HttpImpl(APICredentials credentials, HttpURLConnection httpURLConnection) {
		this(credentials);
		this.httpURLConnection = httpURLConnection;
	}
	/*
	 * (non-Javadoc)
	 * @see com.paynova.api.client.http.Http#delete(String)
	 */
	public HttpEvent delete(String restPath) {
		return doRequest(RestMethod.DELETE,restPath, null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.paynova.api.client.http.Http#get(String)
	 */
	public HttpEvent get(String restPath) {
		return doRequest(RestMethod.GET,restPath,null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.paynova.api.client.http.Http#put(String, String)
	 */
	public HttpEvent post(String restPath, String requestBody) {
		return doRequest(RestMethod.POST,restPath, requestBody);
	}
	
	private void throwPaynovaHttpException(HttpEvent httpEvent, boolean connectionStatusOk) {
		JsonParser parser = new JsonParserImpl();
        StatusWrapper sw = null;
        try{
        	sw = parser.fromJson(httpEvent.getResponseBody(), StatusWrapper.class);
        }catch(Exception e){}
        
        if(sw!=null && sw.getStatus()!=null && !sw.getStatus().getIsSuccess()) {
        	throw new PaynovaHttpException(httpEvent, 
        			sw.getStatus(),
        			sw.getStatus().getStatusMessage()+"\n"+
        			sw.getStatus().getAllErrorsAsString("\n")
        			);
        } else if(!connectionStatusOk) {
        	throw new PaynovaHttpException(httpEvent,httpEvent.getResponseHeadersAsString("\n"));
        }
		
	}
	
	private List<Integer> getOkStatusCodes() {
		return Arrays.asList(200,201);
	}
	
	private HttpEvent doRequest(RestMethod restMethod, String restPath, String requestBody){
		HttpEvent httpEvent = new HttpEvent();
		
		httpEvent.setRequestBody(requestBody);
		
		boolean statusOk = false;
		
		try {
           
			HttpURLConnection connection = buildConnection(restMethod, restPath);
			
			if (requestBody != null) {
				connection.getOutputStream().write(requestBody.getBytes("UTF-8"));
				connection.getOutputStream().close();
		    }
			
		    httpEvent.setCode(connection.getResponseCode());
		    
		    statusOk = getOkStatusCodes().contains(connection.getResponseCode());
		    
		    InputStream responseStream =  statusOk ? connection.getInputStream() : connection.getErrorStream();
		    
		    String responseBody = readStringFromStream(responseStream);
		    
		    httpEvent.setResponseHeaders(connection.getHeaderFields());
		   
		    httpEvent.setResponseBody(responseBody);
		   
           responseStream.close();
           
        } catch (Exception e) {
        	throw new PaynovaHttpException(e,e.toString());
        }
		
		throwPaynovaHttpException(httpEvent, statusOk);
		
		return httpEvent;
	}
	
	
	private String readStringFromStream(InputStream inputStream) throws IOException{
		
		InputStreamReader inputReader = new InputStreamReader(inputStream);
        
		StringBuilder builder = new StringBuilder();
        
		char[] buffer = new char[0x1000];
        
		int bytesRead = inputReader.read(buffer, 0, buffer.length);
        
		while (bytesRead >= 0) {
            builder.append(buffer, 0, bytesRead);
            bytesRead = inputReader.read(buffer, 0, buffer.length);
        }
        
		return builder.toString();
	}
	private HttpURLConnection buildConnection(RestMethod restMethod, String urlString) throws java.io.IOException {
		String stringURL = credentials.getEndpointURL().toString().replaceAll("/$", "") +"/"+ 
        		urlString.replaceAll("^/", "");
        
        
        HttpURLConnection connection = openConnection(stringURL);
        
        connection.setRequestMethod(restMethod.toString());
       
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("User-Agent", "Paynova Java Library v " + Version.get());
        
        connection.addRequestProperty("Authorization", credentials.getBasicAuthStringBase64Encoded());
        connection.addRequestProperty("Content-Type", "application/json");
        
        connection.setDoOutput(true);
        connection.setReadTimeout(60000);
        
        return connection;
    }
	
	public HttpURLConnection openConnection(String stringURL) throws java.io.IOException{
		return (httpURLConnection==null)?(HttpURLConnection)new URL(stringURL).openConnection():httpURLConnection;
	}
	
}
