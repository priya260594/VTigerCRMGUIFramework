package com.VTiger.crm.objectRepositoryutility.ContactsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsSelectionPage {

	@FindBy(id="search_txt")
	private WebElement SearBoxEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBtn;
	
	public ContactsSelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearBoxEdt() {
		return SearBoxEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	public void selectParticularContactName(WebDriver driver,String ContName) {
		SearBoxEdt.sendKeys(ContName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()=' "+ContName+"']")).click();
	}
}
