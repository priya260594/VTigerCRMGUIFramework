package com.VTiger.crm.objectRepositoryutility.servicePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewServicePage extends WebDriverUtility {
	
	@FindBy(name="servicename")
	private WebElement serviceNameEdt;
	
	@FindBy(name="servicecategory")
	private WebElement serviceCategoryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
public CreateNewServicePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getServiceNameEdt() {
	return serviceNameEdt;
}

public WebElement getServiceCategoryDropDown() {
	return serviceCategoryDropDown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public void servicePage(WebDriver driver,String serviceName,String serviceCategory) {
	serviceNameEdt.sendKeys(serviceName);
    selectByValue(serviceCategoryDropDown, serviceCategory);
    saveBtn.click();
}


	
}
