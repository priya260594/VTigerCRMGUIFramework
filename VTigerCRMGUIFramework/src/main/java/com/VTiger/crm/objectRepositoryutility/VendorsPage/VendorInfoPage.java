package com.VTiger.crm.objectRepositoryutility.VendorsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VendorInfoPage {

	@FindBy(id = "dtlview_Vendor Name")
	private WebElement createdVendorName;

	@FindBy(className = "lvtHeaderText")
	private WebElement headerVendorName;

	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getcreatedVendorName() {
		return createdVendorName;
	}

	public WebElement getHeaderVendorName() {
		return headerVendorName;
	}

	public void verifyHeaderVendorName(String vendorNam) {
		boolean flag = headerVendorName.getText().contains(vendorNam);
		Assert.assertTrue(flag);
	}

	public void verifyDisplayedVendorName(String vendorNam) {
		Assert.assertEquals(createdVendorName.getText().trim(), vendorNam);
	}

}
