package com.VTiger.crm.objectRepositoryutility.ProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    @FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createNewProduct; 
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateNewProduct() {
		return createNewProduct;
	}

}
