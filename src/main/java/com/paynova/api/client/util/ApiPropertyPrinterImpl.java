package com.paynova.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.paynova.api.client.model.ApiProperty;
import com.paynova.api.client.model.ApiPropertyList;

public final class ApiPropertyPrinterImpl implements ApiPropertyPrinter{
	
	private String indenter;
	
	private String linebreaker;
	
	public ApiPropertyPrinterImpl() {
		this("\t","\n");
	}
	
	public ApiPropertyPrinterImpl(String indenter, String linebreaker){
		this.setIdenter(indenter);
		this.setLinebreaker(linebreaker);
	}
	
	public String getApiProperties(ApiProperty propertyObj) {
		return getApiProperties(propertyObj,0);
	}
	
	private String getApiProperties(ApiProperty propertyObj, int depth) {
		final String indent = getIndent(depth);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(propertyObj.getClass().getSimpleName() + " ["+getLinebreaker());
		
		List<Field> fields = getAllFieldsFromApiPropertyObject(propertyObj);
		
		for (Field field : fields) {
	    	field.setAccessible(true);
	    	if(!Modifier.isTransient(field.getModifiers())){
    			String fName = field.getName();
    			Object value = "";
    			try {
    				Object fObj = field.get(propertyObj);
    				if(fObj != null) {
    					Class<?> fClass = fObj.getClass();
    					if(fClass.equals(ApiPropertyList.class)){
							ApiPropertyList<?> list = ((ApiPropertyList<?>)fObj);
							StringBuilder sbSub = new StringBuilder();
							sbSub.append(fObj.getClass().getSimpleName() + " {"+getLinebreaker());
							for(Object o:list){
								if(o instanceof ApiProperty) {
									sbSub.append(indent+getIndent(2)+getApiProperties(((ApiProperty)o), depth+2)+","+getLinebreaker());
								}
							}
							sbSub.append(indent+getIndenter()+"}");
							value = sbSub.toString();
						}else if(!field.getType().isPrimitive() && 
	                			!fClass.equals(String.class) && 
	                			implementsApiProperty(fObj) 
	                	){
    						value = getApiProperties(((ApiProperty)fObj), depth+1);
    						
	                	}else {
	                		value = field.get(propertyObj);
	                	}
    				}
                	sb.append(indent+indenter+"(" + field.getType().getSimpleName() + ") " + fName + " = " + value + ","+getLinebreaker());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    	  
	    }
	    sb.append(indent+"]");
	   return sb.toString();
	}
	
	private List<Field> getAllFieldsFromApiPropertyObject(ApiProperty propertyObj) {
		List<Field> fields = new ArrayList<Field>();
		for(Class<?> cl: getAllClassesFromClass( propertyObj.getClass())) {
			fields.addAll(Arrays.asList(cl.getDeclaredFields()));
		}
		return fields;
	}
	
	private boolean implementsApiProperty(Object obj) {
		List<Class<?>> list = getAllInterfaceFromClassList(getAllClassesFromClass(obj.getClass()));
		return list.contains(com.paynova.api.client.model.ApiProperty.class);
	}
	
	private List<Class<?>> getAllInterfaceFromClassList(List<Class<?>> classes) {
		List<Class<?>> list = new ArrayList<Class<?>>();
		for(Class<?> cl: classes){
			list.addAll(Arrays.asList(cl.getInterfaces()));
		}
		return list;
	}
	
	private List<Class<?>> getAllClassesFromClass(Class<?> cl) {
		List<Class<?>> list = new ArrayList<Class<?>>();
		list.add(cl);
		if(cl.getSuperclass() != null && 
				cl.getSuperclass().getPackage().getName().startsWith("com.paynova.api.client")) {
			list.addAll(getAllClassesFromClass(cl.getSuperclass()));
		}
		return list;
	}
	
	private String getIndent(int depth){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<depth;i++) sb.append(getIndenter());
		return sb.toString();
	}
	public String getIndenter() {
		return indenter;
	}
	
	public void setIdenter(String indenter) {
		this.indenter = indenter;
	}
	
	public String getLinebreaker() {
		return linebreaker;
	}

	public void setLinebreaker(String linebreaker) {
		this.linebreaker = linebreaker;
	}
}
