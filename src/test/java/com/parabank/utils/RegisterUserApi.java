package com.parabank.utils;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RegisterUserApi {

	private static final String BASE_URL = "https://parabank.parasoft.com/parabank";
	
	private static String username;
	private static String password;
	
	public static boolean isUserCreated() {
		
		HashMap<String, String> userData = new HashMap<String, String>();
		
		username = ConfigReader.get("username") + System.currentTimeMillis();
		password = ConfigReader.get("password");
		
		userData.put("customer.firstName", "Admin");
		userData.put("customer.lastName", "Test");
		userData.put("customer.address.street", "123/B, Test Street, Test City");
		userData.put("customer.address.city", "Test City");
		userData.put("customer.address.state", "Test State");
		userData.put("customer.address.zipCode", "10000");
		userData.put("customer.phoneNumber", "12345678");
		userData.put("customer.ssn", "1234567");
		userData.put("customer.username", username);
		userData.put("customer.password", password);
		userData.put("repeatedPassword", password);
		
		Response response = RestAssured
				.given()
				.baseUri(BASE_URL)
				.formParams(userData)
				.post("/register.htm");
		
		int statusCode = response.getStatusCode();
				
		if(statusCode == 200 || statusCode == 302) {
			System.out.println("User, " + username + " was created successfully");
			return true;
		}else {
			System.err.println("Failed to create the user: " + username + ". Status code: " + statusCode);
			return false;
		}
	}
	
	public static HashMap<String, String> userData(){
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("username", username);
		data.put("password", password);
		
		return data;
	}
}
