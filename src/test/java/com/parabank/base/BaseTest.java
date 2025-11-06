package com.parabank.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import com.parabank.driver.BrowserDriver;
import com.parabank.utils.ConfigReader;

public class BaseTest {

	protected static WebDriver driver;
	
	public static void setup() {
		
		driver = BrowserDriver.getDriver(ConfigReader.get("browser"));
		
		//Initialize implicit wait
		int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		System.out.println("Setup is hit");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void tearDown() {
		
		if(driver != null) {
			driver.quit();
		}
	}
}
