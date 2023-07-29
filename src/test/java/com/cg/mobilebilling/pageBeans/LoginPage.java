package com.cg.mobilebilling.pageBeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/table/tbody/tr/td[2]/a")
	private WebElement link1;
	public void clickLink1() {
		link1.click();
	}
	
}
