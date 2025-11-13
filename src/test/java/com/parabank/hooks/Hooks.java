package com.parabank.hooks;

import java.util.Map;

import com.parabank.base.BaseTest;
import com.parabank.base.TestContext;
import com.parabank.pages.RegistrationPage;
import com.parabank.utils.ConfigReader;
import com.parabank.utils.JsonDataReader;
import com.parabank.utils.RegisterUserApi;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void beforeScenario() {
		
		BaseTest.setup();
	}
	
	@Before("@login")
	public void registerUserBeforeLogin() {
		//Initializing driver instance
		BaseTest.setup();
		
		String filepath = ConfigReader.get("userRegistrationData");
		Map<String, String> userData = JsonDataReader.getDataByTestName(filepath, "valid_user");
		
		userData.put("username", userData.get("username") + System.currentTimeMillis());
		
		var registerPage = new RegistrationPage(BaseTest.getDriver());
		boolean isUserCreated = registerPage.registerNewUser(userData);
		
		//Quitting driver instance
		BaseTest.tearDown();
		
		//Exit scenario execution if user registration fails
		if(!isUserCreated) {
			throw new RuntimeException("Failed to create the user. Aborting the login script execution...");
		}
		
		TestContext.setData("username", userData.get("username"));
		TestContext.setData("password", userData.get("password"));
	}
	
	@After
	public void afterScenario() {
		
		BaseTest.tearDown();
	}
}
