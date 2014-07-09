package com.paynova.api.client.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import com.paynova.api.client.ExceptionEnum;

public class HttpURLConnectionMock extends HttpURLConnection{
	
	private String url;
	private String mockResponseBody;
	private int responseCode;
	private ExceptionEnum exceptionToThrow;
	public HttpURLConnectionMock(String url, String mockResponseBody, int responseCode, ExceptionEnum exceptionToThrow) throws MalformedURLException {
		super(new URL(url));
		this.url = url;
		this.mockResponseBody = mockResponseBody;
		setMockResponseCode(responseCode);
		this.exceptionToThrow = exceptionToThrow;
	}
	
	public void setMockResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public void disconnect() {}

	@Override
	public boolean usingProxy() {return false;}

	@Override
	public void connect() throws IOException { }
	
	@Override
	public int getResponseCode() throws UnknownHostException{
		if(exceptionToThrow ==ExceptionEnum.UNKNOWN_HOST) {
			throw new UnknownHostException(url);
		}
		return responseCode;
	}
	
	public OutputStream getOutputStream() {
		return new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				if(exceptionToThrow ==ExceptionEnum.UNKNOWN_HOST) {
					throw new UnknownHostException(url);
				}
			}
		};
	}
	
	public InputStream getInputStream() throws UnknownHostException{
		if(exceptionToThrow ==ExceptionEnum.UNKNOWN_HOST) {
			throw new UnknownHostException(url);
		}
		return getDefaultInputStream();
	}
	
	public InputStream getErrorStream() {
		return getDefaultInputStream();
	}
	
	private InputStream getDefaultInputStream() {
		
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(mockResponseBody.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return in;
	}
}
