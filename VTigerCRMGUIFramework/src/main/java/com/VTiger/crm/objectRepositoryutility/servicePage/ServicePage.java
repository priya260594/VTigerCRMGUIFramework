package com.VTiger.crm.objectRepositoryutility.servicePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage {

	@FindBy(xpath = "//img[@alt='Create Service...']")
	private WebElement newServicePage;

	public ServicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getnewServicePage() {
		return newServicePage;
	}
}
