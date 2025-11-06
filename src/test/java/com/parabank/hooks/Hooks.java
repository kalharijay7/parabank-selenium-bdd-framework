package com.parabank.hooks;

import com.parabank.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void beforeScenario() {
		
		BaseTest.setup();
	}
	
	@After
	public void afterScenario() {
		
		BaseTest.tearDown();
	}
}
