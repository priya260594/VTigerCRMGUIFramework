package com.VTiger.crm.objectRepositoryutility.ProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductInfoPage {

	@FindBy(id = "dtlview_Product Name")
	private WebElement createdProdName;

	@FindBy(className = "lvtHeaderText")
	private WebElement HeaderProductName;

	@FindBy(id = "mouseArea_Vendor Name")
	private WebElement displayedVendorNameTxt;

	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatedProdName() {
		return createdProdName;
	}

	public WebElement getHeaderProductName() {
		return HeaderProductName;
	}

	public WebElement getDisplayedVendorNameTxt() {
		return displayedVendorNameTxt;
	}

	public void verifyDisplayedProductName(String productName) {
		Assert.assertEquals(createdProdName.getText(), productName);
		}

	public void verifyHeaderProductName(String productName) {
		boolean flag=HeaderProductName.getText().contains(productName);
		Assert.assertTrue(flag);
	}

	public void verifyVendorName(String vendorNam) {
		Assert.assertEquals(displayedVendorNameTxt.getText().trim(), vendorNam);
    }

}
