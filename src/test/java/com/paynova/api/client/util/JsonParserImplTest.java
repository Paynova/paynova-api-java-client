package com.paynova.api.client.util;

import java.awt.Point;

import junit.framework.TestCase;

import org.junit.Test;

public class JsonParserImplTest extends TestCase{
	
	@Test
	public void testToJson() {
		JsonParser parser = new JsonParserImpl();
		FooProperty foo = new FooProperty("field1", "field2", new Point(100,200));
		String json = parser.toJson(foo);
		assertTrue(json.equals("{\"field1\":\"field1\",\"point\":{\"x\":100,\"y\":200}}"));
	}
	
	@Test
	public void testFromJson() {
		JsonParser parser = new JsonParserImpl();
		String json = "{\"field1\":\"field1\",\"point\":{\"x\":100,\"y\":200}}";
		FooProperty foo = parser.fromJson(json, FooProperty.class);
		assertEquals(foo.getField1(),"field1");
		assertTrue(foo.getPoint().x==100);
	}
}
