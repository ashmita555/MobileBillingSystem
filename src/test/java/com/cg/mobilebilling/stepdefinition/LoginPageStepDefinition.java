package com.cg.mobilebilling.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.mobilebilling.pageBeans.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStepDefinition {
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		/*System.setProperty("webdriver.chrome.driver", "D:\\Rishabh Tandon\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:5555/");
		loginPage=PageFactory.initElements(driver, LoginPage.class);*/
	}

	@When("^User enter valid customer id to login into the account and click on login button$")
	public void user_enter_valid_customer_id_to_login_into_the_account_and_click_on_login_button() throws Throwable {
	 /* driver.close();*/
	}

	@Then("^User goes to the welcome page$")
	public void user_goes_to_the_welcome_page() throws Throwable {
	  
	}

	@When("^User enter invalid customer id to login into the account and click on login button$")
	public void user_enter_invalid_customer_id_to_login_into_the_account_and_click_on_login_button() throws Throwable {
	  /*driver.close();*/
	}

	@Then("^User gets the error message$")
	public void user_gets_the_error_message() throws Throwable {
	  
	}

	@When("^User clicks on the New User link$")
	public void user_clicks_on_the_New_User_link() throws Throwable {
		/*loginPage.clickLink1();*/
	}

	@Then("^User goes to the open account page$")
	public void user_goes_to_the_open_account_page() throws Throwable {
	  
	}

}
