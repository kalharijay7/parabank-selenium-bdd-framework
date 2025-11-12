package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.utils.ConfigReader;

public class RegistrationPage {

	private WebDriver driver;
	
	@FindBy(id = "customer.firstName")
	private WebElement firstName;
	
	@FindBy(id = "customer.lastName")
	private WebElement lastName;
	
	@FindBy(id = "customer.address.street")
	private WebElement streetAddress;
	
	@FindBy(id = "customer.address.city")
	private WebElement city;
	
	@FindBy(id = "customer.address.state")
	private WebElement state;
	
	@FindBy(id = "customer.address.zipCode")
	private WebElement zipCode;
	
	@FindBy(id = "customer.phoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(id = "customer.ssn")
	private WebElement ssn;
	
	@FindBy(id = "customer.username")
	private WebElement userName;
	
	@FindBy(id = "customer.password")
	private WebElement userPassword;
	
	@FindBy(id = "repeatedPassword")
	private WebElement repeatedPassword;
	
	@FindBy(css = "input[value = 'Register']")
	private WebElement submitButton;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean registerNewUser(String username, String password) {
		
		driver.get(ConfigReader.get("userRegisterUrl"));
		
		firstName.sendKeys("Admin");
		lastName.sendKeys("Test");
		streetAddress.sendKeys("123/B, Test Street, Test City");
		city.sendKeys("Test City");
		state.sendKeys("Test State");
		zipCode.sendKeys("10000");
		phoneNumber.sendKeys("12345678");
		ssn.sendKeys("1234567");
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		repeatedPassword.sendKeys(password);
		
		submitButton.click();
		
		return driver.getPageSource().contains("Welcome " + username);
	}
}
