package com.VTiger.crm.objectRepositoryutility.ContactsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createNewContact; 
	
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateNewContact() {
		return createNewContact;
	}
	
}
