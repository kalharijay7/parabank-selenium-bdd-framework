package com.parabank.base;

import java.util.HashMap;

public class TestContext {
	
	protected static HashMap<String, String> data = new HashMap<String, String>();
	
	public static void setData (String key, String value) {
		
		data.put(key, value);
	}

	public static String get(String key) {
		
		return data.get(key);
	}
}
