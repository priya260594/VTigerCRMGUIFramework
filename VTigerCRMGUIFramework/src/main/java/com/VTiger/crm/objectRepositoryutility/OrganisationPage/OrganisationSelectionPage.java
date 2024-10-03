package com.VTiger.crm.objectRepositoryutility.OrganisationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganisationSelectionPage extends WebDriverUtility {

	@FindBy(id="search_txt")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	public OrganisationSelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//WebElement org=driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void OrgSelectPage(WebDriver driver,String orgName) {
	searchBoxEdt.sendKeys(orgName);
	searchBtn.click();
	driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();}

	
}
