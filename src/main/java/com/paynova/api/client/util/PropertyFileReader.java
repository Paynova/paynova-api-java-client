package com.paynova.api.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader {
	
	private static Map<String, Properties> propertyFiles = new HashMap<String, Properties>();
	
	private PropertyFileReader() {
		// TODO Auto-generated constructor stub
	}
	
	private static String constructFullFileName(String pathToFile, String fileName) {
		return pathToFile+fileName;
	}
	
	private static Properties getProperties(String file) {
		for (Map.Entry<String, Properties> entry :propertyFiles.entrySet()) {
			if(entry.getKey().equals(file)){
				return entry.getValue();
			}
		}
		return loadPropertyFile(file);
	}
	
	private static Properties loadPropertyFile(String file) {
		Properties properties = new Properties();
    	InputStream input = null;
 
    	try {
    		
    		input = PropertyFileReader.class.getClassLoader().getResourceAsStream(file);
    		
    		if(input==null){
    	            
    		    return null;
    		}
    		properties.load(input);
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
        			input.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        }
    	propertyFiles.put(file, properties);
    	return properties;
	}
	
	/**
	 * Reads a property from a Properties files and returns it as a String
	 * @param pathToFile the path to where the properties file is located
	 * @param fileName	the name of the properties file
	 * @param property	the property of interest
	 * @return	the property in String format or an (not NULL) empty String if not found
	 */
	public static String getPropertyFromFile(String pathToFile, String fileName, String property) {
		Properties properties = getPropertiesFromFile(pathToFile, fileName);
		
		if(properties == null || !properties.containsKey(property))return "";
		return properties.getProperty(property);
	}
	
	/**
	 * Reads a properties files and loads an Properties instance and returns it
	 * @param pathToFile the path to where the properties file is located
	 * @param fileName	the name of the properties file
	 * @return a Properties instance or null if the properties file not could be found
	 */
	public static Properties getPropertiesFromFile(String pathToFile, String fileName){
		String fullPath = constructFullFileName(pathToFile, fileName);
		Properties properties = getProperties(fullPath);
		return properties;
	}
}
