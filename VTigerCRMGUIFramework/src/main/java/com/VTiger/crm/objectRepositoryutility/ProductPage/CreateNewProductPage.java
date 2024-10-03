package com.VTiger.crm.objectRepositoryutility.ProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorLookUpPage;

public class CreateNewProductPage extends WebDriverUtility {

	@FindBy(xpath="//input[@class='detailedViewTextBox' and @name='productname']")
	private WebElement newProductEdt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement vendorLookUpBtn;
	
	@FindBy(id="qtyinstock")
    private WebElement stockQuantityEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getnewProductEdt() {
		return newProductEdt;
	}
	public WebElement getsaveBtn() {
		return saveBtn;	}
	
	public WebElement getVendorLookUpBtn() {
		return vendorLookUpBtn;
	}
	public WebElement getstockQuantityEdt() {
		return stockQuantityEdt;
	}

	public void createProduct(String prodName) {
		newProductEdt.sendKeys(prodName);
		saveBtn.click();
	}
	public void createProduct(WebDriver driver,String productName,String vendorNam) {
		newProductEdt.sendKeys(productName);
		vendorLookUpBtn.click();
		SwitchingTabsUsingURL(driver, "module=Vendors&action");
		
		VendorLookUpPage vlp=new VendorLookUpPage(driver);
		vlp.vendorLookUpSearch(driver,vendorNam);
		
		SwitchingTabsUsingURL(driver, "module=Products&action");
		saveBtn.click();
		
	}
	public void createProdNameWithQty(String prodName, String quantity){
		newProductEdt.sendKeys(prodName);
		stockQuantityEdt.sendKeys(quantity);
		saveBtn.click();
	}
}
