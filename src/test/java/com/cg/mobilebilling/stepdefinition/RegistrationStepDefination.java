package com.cg.mobilebilling.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.mobilebilling.pageBeans.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepDefination {
	private WebDriver driver;
	private RegistrationPage registrationPage;
	
	@Given("^User is on registration Page$")
	public void user_is_on_registration_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Rishabh Tandon\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:5555/accountOpeningPage");
		registrationPage=PageFactory.initElements(driver,RegistrationPage.class);
	}
	
	@When("^User enter his correct personal details and click on submit button$")
	public void user_enter_his_correct_personal_details_and_click_on_submit_button() throws Throwable {
		/*registrationPage.setFirstName("Rohit");
		registrationPage.setLastName("Walia");
		registrationPage.setEmailID("rt@gmail.com");
		registrationPage.setDateOfBirth("31/10/1995");
		registrationPage.setCity("Khanna");
		registrationPage.setState("Punjab");
		registrationPage.setPinCode("141401");
		registrationPage.setPlanID("5001");
		registrationPage.clickSignUp();*/
	}

	@Then("^User is redirected to registration page and message gets displayed$")
	public void user_is_redirected_to_registration_page_and_message_gets_displayed() throws Throwable {
		/*String actualTitle=driver.getTitle();
		String expectedTitle="Registration Successful!";
		Assert.assertEquals(expectedTitle, actualTitle);
		String actualMessage=registrationPage.getSuccessfulMessage();
		String expectedMessage="110";
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.close();*/
	}
	
	@When("^User enter incorrect personal details with empty fieldsand click on submit button$")
	public void user_enter_incorrect_personal_details_with_empty_fieldsand_click_on_submit_button() throws Throwable {
		registrationPage.clickSignUp();
	}

	@Then("^User gets error message$")
	public void user_gets_error_message() throws Throwable {
		Assert.assertEquals("Enter first name",registrationPage.getErrorMessage1());
		Assert.assertEquals("Enter last name",registrationPage.getErrorMessage2());
		Assert.assertEquals("Enter email", registrationPage.getErrorMessage3());
		Assert.assertEquals("Enter dateOfBirth", registrationPage.getErrorMessage4());
		driver.close();
	}
	
}
