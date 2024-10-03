package com.VTiger.crm.objectRepositoryutility.servicePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceInfoPage {

	@FindBy(className="lvtHeaderText")
	private WebElement headerServiceName;
	
	public ServiceInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderServiceName() {
		return headerServiceName;
	}
	
	
}
