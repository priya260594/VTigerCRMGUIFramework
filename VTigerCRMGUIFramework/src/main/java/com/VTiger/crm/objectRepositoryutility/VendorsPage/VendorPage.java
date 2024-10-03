package com.VTiger.crm.objectRepositoryutility.VendorsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement newVendorBtn;

	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getnewVendorBtn() {
		return newVendorBtn;
	}
	
	
}
