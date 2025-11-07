package com.parabank.base;

import java.util.HashMap;

public class TestContext {
	
	protected static HashMap<String, String> inputData = new HashMap<String, String>();
	
	public static void setInputData (String key, String value) {
		
		inputData.put(key, value);
	}

	public static String get(String key) {
		
		return inputData.get(key);
	}
}
