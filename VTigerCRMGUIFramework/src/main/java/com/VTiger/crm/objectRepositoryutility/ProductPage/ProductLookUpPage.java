package com.VTiger.crm.objectRepositoryutility.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class ProductLookUpPage extends WebDriverUtility {

	@FindBy(id = "search_txt")
	private WebElement searchBoxEdt;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//td[@class='moduleName' and text()='Products']")
	private WebElement ProductPageTxt;

	public ProductLookUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getProductPageTxt() {
		return ProductPageTxt;
	}
	public void clickParticularProduct(WebDriver driver, String prodName) {
		waitForElementVisible(driver, ProductPageTxt);
		searchBoxEdt.sendKeys(prodName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
	}
}
