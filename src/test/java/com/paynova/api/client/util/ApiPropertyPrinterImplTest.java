package com.paynova.api.client.util;

import java.awt.Point;

import junit.framework.TestCase;

import org.junit.Test;

public class ApiPropertyPrinterImplTest extends TestCase{
	
	@Test
	public void testGetApiProperties() {
		FooProperty foo = new FooProperty("field1", "field2", new Point(100,200));
		ApiPropertyPrinter printer = new ApiPropertyPrinterImpl();
		String str = foo.getApiProperties(printer );
		
		assertTrue(str.contains("field1"));
		assertTrue(!str.contains("field2"));
		assertTrue(str.contains("point"));
		
		
	}
}
