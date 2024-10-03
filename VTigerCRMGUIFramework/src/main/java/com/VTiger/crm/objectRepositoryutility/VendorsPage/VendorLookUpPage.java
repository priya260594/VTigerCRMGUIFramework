package com.VTiger.crm.objectRepositoryutility.VendorsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorLookUpPage {

	@FindBy(id="search_txt")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public VendorLookUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//WebElement org=driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void vendorLookUpSearch(WebDriver driver,String vendorName) {
		searchBoxEdt.sendKeys(vendorName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
	}
	
}
