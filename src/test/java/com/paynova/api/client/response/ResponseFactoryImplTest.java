package com.paynova.api.client.response;

import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.http.HttpEvent;

public class ResponseFactoryImplTest extends TestCase {

	@Test
	public void testTreateInstance() {
		ResponseFactory factory = new ResponseFactoryImpl();
		
		
		String response = "{\"status\":{\"isSuccess\":true,\"errorNumber\":0,\"statusKey\":\"SUCCESS\",\"statusMessage\":\"The operation was successful.\"},\"totalAmountRefunded\":\"100\",\"canRefundAgain\":false,\"transactionId\":\"201407021913436107\",\"batchId\":\"183030203046\",\"acquirerId\":\"1010\"}";
		
		HttpEvent httpEvent = new HttpEvent(200,new HashMap<String,List<String>>(),"",new HashMap<String,List<String>>(),response);
		
		assertTrue(factory.createInstance(CreateOrderResponse.class, httpEvent).getClass().getSimpleName().equals("CreateOrderResponse"));
	}

}
