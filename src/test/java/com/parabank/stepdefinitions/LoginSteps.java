package com.parabank.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

	private LoginPage loginPage;
	private WebDriver driver;
	
	public LoginSteps () {
		driver = BaseTest.getDriver();
	}
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		loginPage = new LoginPage(driver);
	}
	
	@When("the user enters valid username {string} and password {string}")
	public void the_user_enters_valid_username_and_passwrod(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}
	
	@And("clicks on the login button")
	public void clicks_on_the_login_button() {
		loginPage.clickLogin();
	}
	
	@Then("the user should be redirected to accounts overview page")
	public void the_user_should_be_redirected_to_accounts_overview_page() {
		String pageTitle = driver.getTitle();
		
		Assert.assertTrue(pageTitle.contains("Accounts Overview"));
	}
}
