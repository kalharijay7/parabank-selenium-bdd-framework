package com.parabank.hooks;

import com.parabank.base.BaseTest;
import com.parabank.base.TestContext;
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
		boolean isUserCreated = RegisterUserApi.isUserCreated();
		
		//Exit scenario execution if user registration fails
		if(!isUserCreated) {
			throw new RuntimeException("Failed to create the user. Aborting the login script execution...");
		}
		
		TestContext.setData("username", RegisterUserApi.userData().get("username"));
		TestContext.setData("password", RegisterUserApi.userData().get("password"));
	}
	
	@After
	public void afterScenario() {
		
		BaseTest.tearDown();
	}
}
