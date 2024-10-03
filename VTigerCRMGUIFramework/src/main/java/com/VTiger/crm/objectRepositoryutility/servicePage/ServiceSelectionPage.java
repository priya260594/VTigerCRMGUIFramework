package com.VTiger.crm.objectRepositoryutility.servicePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class ServiceSelectionPage extends WebDriverUtility{

	@FindBy(id="search_txt")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search_field")
	private WebElement searchCategoryDropDown;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public ServiceSelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchCategoryDropDown() {
		return searchCategoryDropDown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void clickParticularService(WebDriver driver, String ServiceName) {
		select(searchCategoryDropDown, "Service Name");
		searchBoxEdt.sendKeys(ServiceName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ServiceName+"']")).click();
	}
}
