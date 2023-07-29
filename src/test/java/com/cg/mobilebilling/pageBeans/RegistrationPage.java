package com.cg.mobilebilling.pageBeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
	@FindBy(how=How.ID, id="firstName")
	private WebElement firstName;
	
	@FindBy(how=How.ID, id="lastName")
	private WebElement lastName;
	
	@FindBy(how=How.ID, id="emailID")
	private WebElement emailID;
	
	@FindBy(how=How.ID, id="dateOfBirth")
	private WebElement dateOfBirth;
	
	@FindBy(how=How.ID, id="address.city")
	private WebElement city;
	
	@FindBy(how=How.ID, id="address.state")
	private WebElement state;
	
	@FindBy(how=How.ID, id="address.pinCode")
	private WebElement pinCode;
	
	@FindBy(name="planID")
	private WebElement planID;

	@FindBy(xpath="//*[@id=\"customer\"]/table/tbody/tr[9]/td/input")
	private WebElement button;
	
	@FindBy(xpath="/html/body/p[2]")
	private WebElement successfulMessage;
	
	@FindBy(xpath="//*[@id=\"firstName.errors\"]")
	private WebElement errorMessage1;
	
	@FindBy(how=How.ID,id="lastName.errors")
	private WebElement errorMessage2;
	
	@FindBy(xpath="//*[@id=\"emailID.errors\"]")
	private WebElement errorMessage3;
	
	@FindBy(how=How.ID,id="dateOfBirth.errors")
	private WebElement errorMessage4;
	
	public String getErrorMessage1() {
		return errorMessage1.getText();
	}

	public String getErrorMessage2() {
		return errorMessage2.getText();
	}

	public String getErrorMessage3() {
		return errorMessage3.getText();
	}

	public String getErrorMessage4() {
		return errorMessage4.getText();
	}

	public String getSuccessfulMessage() {
		return successfulMessage.getText();
	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public String getEmailID() {
		return emailID.getAttribute("value");
	}

	public void setEmailID(String emailID) {
		this.emailID.sendKeys(emailID);
	}

	public String getDateOfBirth() {
		return dateOfBirth.getAttribute("value");
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.sendKeys(dateOfBirth);
	}

	public String getCity() {
		return city.getAttribute("value");
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public String getState() {
		return state.getAttribute("value");
	}

	public void setState(String state) {
		this.state.sendKeys(state);
	}

	public String getPinCode() {
		return pinCode.getAttribute("value");
	}

	public void setPinCode(String pinCode) {
		this.pinCode.clear();
		this.pinCode.sendKeys(pinCode);
	}

	public String getPlanID() {
		return planID.getAttribute("value");
	}

	public void setPlanID(String planID) {
		this.planID.sendKeys(planID);
	}
	
	public void clickSignUp() {
		button.submit();
	}
	
}
