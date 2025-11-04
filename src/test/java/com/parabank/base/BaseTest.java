package com.parabank.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.parabank.driver.BrowserDriver;
import com.parabank.utils.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	
	public void setup() {
		
		driver = BrowserDriver.getDriver(ConfigReader.get("browser"));
		
		//Initialize implicit wait
		int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		System.out.println("Setup is hit");
	}
	
	public void tearDown() {
		
		if(driver != null) {
			driver.quit();
		}
	}
}
