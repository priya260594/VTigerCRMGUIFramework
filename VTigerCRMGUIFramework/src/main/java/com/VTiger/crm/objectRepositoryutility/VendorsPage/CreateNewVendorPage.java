package com.VTiger.crm.objectRepositoryutility.VendorsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	@FindBy(xpath="//input[@class='detailedViewTextBox' and @name='vendorname']")
	private WebElement newVendorEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getnewVendorEdt() {
		return newVendorEdt;
	}
	public WebElement getsaveBtn() {
		return saveBtn;	}
	
	public void createVendor(String vendorNam) {
		newVendorEdt.sendKeys(vendorNam);
		saveBtn.click();}
}
