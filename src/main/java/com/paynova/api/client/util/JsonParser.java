package com.paynova.api.client.util;

import java.lang.reflect.Type;

public interface JsonParser {
	
	public String toJson(Object src);
	
	public <T> T fromJson(String json, Type typeOfT);
}
