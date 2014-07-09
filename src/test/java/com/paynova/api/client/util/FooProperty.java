package com.paynova.api.client.util;

import java.awt.Point;

import com.paynova.api.client.model.ApiProperty;

public class FooProperty implements ApiProperty{
	
	private String field1;
	
	private transient String field2;
	
	private Point point;
	
	public FooProperty(String f1,String f2, Point p) {
		field1 = f1;
		field2 = f2;
		point = p;
	}
	public String getField1(){ return field1;}
	
	public String getField2(){ return field2;}
	
	public Point getPoint(){ return point;}
	
	public String getApiProperties(ApiPropertyPrinter printer) {
		return printer.getApiProperties(this);
	}
}
