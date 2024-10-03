package com.VTiger.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
//1. create separate java class
public class LoginPage extends WebDriverUtility{
//	WebDriver driver; //declaring as global
	public LoginPage(WebDriver driver) { //take care of obj initialization, loading obj and executing of all annotation with current address
//		this.driver=driver; //to make driver object as global we use this line
		PageFactory.initElements(driver, this);
	}
	
	//2. object identification
	@FindBy(name="user_name")
    private WebElement usernameEdit;

	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	//3. object initialization

	
	//4.Object Encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//5.object utilization
	public void loginToApplication(String username,String password) {
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		submitButton.click();
	}
	
	
}
