package com.paynova.api.client.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.paynova.api.client.org.apache.commons.codec.binary.Hex;
import com.paynova.api.client.org.apache.commons.codec.digest.DigestUtils;

public class DigestValidator {
	
	/**
	 * Validate the DIGEST for the POST-redirect
	 * Helper function that can be used to verify the DIGEST (sha1) code for the POST-redirect
	 * when the customer comes back from the payment-window-process.
	 * See the API documentation for the POST-redirect
	 * @param postParameters params to build the digest 
	 * @param secretKey the secret key associated with the merchant account
	 * @return boolean true if DIGEST can be verified
	 */
	public static boolean verify_POST_REDIRECT_DIGEST(Map<String, String> postParameters, String secretKey) {
		String[] basicNeeded = new String[]{
				"ORDER_ID","SESSION_ID","ORDER_NUMBER","SESSION_STATUS","CURRENCY_CODE"
		};
		String[] paymentNeeded = new String[]{
				"PAYMENT_#_STATUS","PAYMENT_#_TRANSACTION_ID","PAYMENT_#_AMOUNT"
		};
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0;i<basicNeeded.length;i++) {
			builder.append(postParameters.get(basicNeeded[i])+";");
		}
		
		for(int i=1;i<=Integer.parseInt(postParameters.get("PAYMENT_COUNT"));i++) {
			for(int j = 0;j<paymentNeeded.length;j++) {
				String key = paymentNeeded[j].replaceFirst("#", ""+i);
				builder.append(postParameters.get(key)+";");
			}
		}
		builder.append(secretKey);//Not that separator was added in the last for loop
		
		return digestIsVerified(builder.toString(), postParameters.get("DIGEST"));
	}
	
	/**
	 * Validate the DIGEST for a Event Hook Notification (EHN)
	 * Helper function that can be used to verify the DIGEST (sha1) code for the POST-parameters sent when
	 * the customer is at the payment window (card added, card removed, payment, session end)
	 * See the API documentation for the EHNs
	 * @param postParameters params to build the digest 
	 * @param secretKey the secret key associated with the merchant account
	 * @return boolean true if DIGEST can be verified
	 */
	public static boolean verify_EVENT_HOOK_BODY_DIGEST(Map<String, String> postParameters, String secretKey) {
		
		String[] basicNeeded = new String[]{
				"EVENT_TYPE","EVENT_TIMESTAMP","DELIVERY_TIMESTAMP","MERCHANT_ID"
		};
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0;i<basicNeeded.length;i++) {
			builder.append(postParameters.get(basicNeeded[i])+";");
		}
		builder.append(secretKey);//Not that separator was added in the last for loop
		
		return digestIsVerified(builder.toString(), postParameters.get("DIGEST"));
	}
	
	/**
	 * Verify the DIGEST (pn-digest) sent in the header of a EVENT HOOK
	 * return true / false 
	 * @param secretKey associated with the merchant account
	 * @param pnDigest the value of the header key pn-digest, received from the API server in the response header
	 * @param rawPOSTdata the raw POST data received from the API server in the response body
	 * @return boolean if the pn-digest is verified
	 */
	public static boolean verify_EVENT_HOOK_HEADER_DIGEST(String secretKey, String pnDigest, String rawPOSTdata) {
		return digestIsVerified(rawPOSTdata+secretKey,pnDigest);
	}
	
	private static boolean digestIsVerified(String strToSha, String digest) {
		try {
			strToSha = new String(Hex.encodeHex(DigestUtils.sha(strToSha.getBytes("UTF-8")))).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return digest.equals(strToSha);
	}
}
