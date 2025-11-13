package com.parabank.pages;

import java.util.Map;

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
	
	public boolean registerNewUser(Map<String, String> userData) {
		
		driver.get(ConfigReader.get("userRegisterUrl"));
		
		firstName.sendKeys(userData.get("firstName"));
		lastName.sendKeys(userData.get("lastName"));
		streetAddress.sendKeys(userData.get("address"));
		city.sendKeys(userData.get("city"));
		state.sendKeys(userData.get("state"));
		zipCode.sendKeys(userData.get("address"));
		phoneNumber.sendKeys(userData.get("phone"));
		ssn.sendKeys(userData.get("ssn"));
		userName.sendKeys(userData.get("username"));
		userPassword.sendKeys(userData.get("password"));
		repeatedPassword.sendKeys(userData.get("confirmPassword"));
		
		submitButton.click();
		
		return driver.getPageSource().contains("Welcome " + userData.get("username"));
	}
}
