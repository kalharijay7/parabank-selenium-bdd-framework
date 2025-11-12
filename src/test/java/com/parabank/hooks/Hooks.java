package com.parabank.hooks;

import com.parabank.base.BaseTest;
import com.parabank.base.TestContext;
import com.parabank.pages.RegistrationPage;
import com.parabank.utils.ConfigReader;
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
		BaseTest.setup();
		
		String username = ConfigReader.get("username") + System.currentTimeMillis();
		String password = ConfigReader.get("password");
		
		var registerPage = new RegistrationPage(BaseTest.getDriver());
		boolean isUserCreated = registerPage.registerNewUser(username, password);
		
		//Exit scenario execution if user registration fails
		if(!isUserCreated) {
			throw new RuntimeException("Failed to create the user. Aborting the login script execution...");
		}
		
		TestContext.setData("username", username);
		TestContext.setData("password", password);
	}
	
	@After
	public void afterScenario() {
		
		BaseTest.tearDown();
	}
}
