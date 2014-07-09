package com.paynova.api.client.integrationtest;

import java.math.BigDecimal;
import java.util.UUID;

import junit.framework.TestCase;

import org.junit.Test;

import com.paynova.api.client.APICredentials;
import com.paynova.api.client.ExceptionEnum;
import com.paynova.api.client.PaynovaClient;
import com.paynova.api.client.TestHelper;
import com.paynova.api.client.exception.PaynovaHttpException;
import com.paynova.api.client.request.RefundPaymentRequest;
import com.paynova.api.client.response.RefundPaymentResponse;

public class RefundPaymentTest extends TestCase{
	
	private boolean forceLocalTests = true;
	
	private APICredentials apiC = null;
	
	@Test
	public void testRefundPaymentExpectSuccess() {
		UUID orderId = UUID.fromString("77a6751a-103e-4823-9769-a35c01194ddc");
		String transactionId = "201407021904297476";
		BigDecimal totalAmount = new BigDecimal(100.00);
		String mockResponse = TestHelper.getJsonResponse("response.refundpayment.success");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		RefundPaymentRequest request = new RefundPaymentRequest(orderId, transactionId, totalAmount);
		try{
			RefundPaymentResponse response = client.refundPayment(request);
			assertTrue(response.getStatus().getIsSuccess());
			assertEquals(totalAmount,response.getTotalAmountRefunded());
		}catch(PaynovaHttpException phe) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testRefundPaymentFailDueToBadTransactionId() {
		UUID orderId = UUID.fromString("77a6751a-103e-4823-9769-a35c01194ddc");
		String transactionId = "201407021904297476";
		BigDecimal totalAmount = new BigDecimal(100.00);
		String mockResponse = TestHelper.getJsonResponse("response.refundpayment.fail");
		PaynovaClient client = TestHelper.getPaynovaClient(
				mockResponse, 201, ExceptionEnum.NONE, apiC, forceLocalTests
				);
		RefundPaymentRequest request = new RefundPaymentRequest(orderId, transactionId, totalAmount);
		try{
			client.refundPayment(request);
			assertTrue(false);
		}catch(PaynovaHttpException phe) {
			assertTrue(!phe.getStatus().getIsSuccess());
		}
	}

}
