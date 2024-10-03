package com.VTiger.crm.objectRepositoryutility.PurchaseOrderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

	@FindBy(xpath = "//img[@alt='Create Purchase Order...']")
	private WebElement newPurchaseOrder;

	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getnewPurchaseOrder() {
		return newPurchaseOrder;
	}

}
