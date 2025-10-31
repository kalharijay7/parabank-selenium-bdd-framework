package com.parabank.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties props = new Properties();
	
	static {
		loadProperties();
	}
			
	private static void loadProperties() {
		
		String env = System.getProperty("environment", "prod"); //defaults to prod
		String fileName = String.format("config.%s.properties", env);
		
		try(InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)){
			
			if(input == null) {
				throw new RuntimeException("Config file not found: " + fileName);
			}
			
			props.load(input);
			System.out.println("✅ Loaded environment: " + env);
		}
		catch(Exception e) {
			throw new RuntimeException("❌ Failed to load config file: " + fileName, e);
		}
	}
	
	public static String get(String key) {
		return props.getProperty(key);
	}
			
}
