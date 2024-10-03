package com.VTiger.crm.objectRepositoryutility.PurchaseOrderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PurchaseOrderInfoPage {
	SoftAssert sa = new SoftAssert();

	@FindBy(id = "dtlview_Subject")
	private WebElement displayedSubName;

	@FindBy(className = "lvtHeaderText")
	private WebElement headerSubName;

	@FindBy(id = "mouseArea_Vendor Name")
	private WebElement displayedVendorName;

	@FindBy(id = "dtlview_Billing Address")
	private WebElement displayedBillingAddress;

	@FindBy(id = "dtlview_Shipping Address")
	private WebElement displayedShippingAddress;

	@FindBy(id = "mouseArea_Contact Name")
	private WebElement displayedContName;

	@FindBy(xpath = "//tr[@valign='top'][3]/td[1]")
	private WebElement displayedProd;

	@FindBy(xpath = "//tr[@valign='top'][3]/td[2]")
	private WebElement displayedQty;

	@FindBy(xpath = "//tr[@valign='top'][4]/td[1]")
	private WebElement displayedsecondRowItemName;

	public PurchaseOrderInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDisplayedSubName() {
		return displayedSubName;
	}

	public WebElement getHeaderSubName() {
		return headerSubName;
	}

	public WebElement getDisplayedVendorName() {
		return displayedVendorName;
	}

	public WebElement getDisplayedBillingAddress() {
		return displayedBillingAddress;
	}

	public WebElement getDisplayedShippingAddress() {
		return displayedShippingAddress;
	}

	public WebElement getDisplayedProd() {
		return displayedProd;
	}

	public WebElement getDisplayedQty() {
		return displayedQty;
	}

	public WebElement getdisplayedContName() {
		return displayedContName;
	}

	public WebElement getdisplayedsecondRowItemName() {
		return displayedsecondRowItemName;
	}

	public void verifydisplayedSubName(String subName) {
		Assert.assertEquals(displayedSubName.getText(), subName);
	}

	public void verifyheaderSubName(String subName) {
		Boolean flag = headerSubName.getText().contains(subName);
		Assert.assertTrue(flag);
	}

	public void verifyVendorName(String vendorName) {
		sa.assertEquals(displayedVendorName.getText().trim(), vendorName);
		sa.assertAll();
	}

	public void verifyDisplayedBillAddress(String address) {
		sa.assertEquals(displayedBillingAddress.getText(), address);
		sa.assertAll();
	}

	public void verifyDisplayedShippingAddress(String address) {
		sa.assertEquals(displayedShippingAddress.getText(), address);
		sa.assertAll();
	}

	public void verifyProductName(WebDriver driver, String prodName) {
//		WebElement Prod=driver.findElement(By.xpath("//td[contains(text(),'"+prodName+"')]"));
		Assert.assertEquals(displayedProd.getText().trim(), prodName);
	}

	public void verifyQuantity(String quantity) {
		boolean flag=displayedQty.getText().contains(quantity);
		Assert.assertTrue(flag);
	}

	public void verifyContactName(String LastName) {
		sa.assertEquals(displayedContName.getText().trim(), LastName);
		sa.assertAll();
	}

	public void verifyServiceName(String ServiceName) {
		sa.assertEquals(displayedsecondRowItemName.getText().trim(), ServiceName);
		sa.assertAll();
	}
}
