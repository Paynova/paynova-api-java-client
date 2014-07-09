package com.paynova.api.client.util;

import java.lang.reflect.Type;

import com.paynova.api.client.com.google.gson.Gson;


public class JsonParserImpl implements JsonParser{
	private Gson gson;
	public JsonParserImpl() {
		// TODO Auto-generated constructor stub
		gson = new Gson();
	}
	public String toJson(Object src) {
		return gson.toJson(src);
	}
	public <T> T fromJson(String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}
}
