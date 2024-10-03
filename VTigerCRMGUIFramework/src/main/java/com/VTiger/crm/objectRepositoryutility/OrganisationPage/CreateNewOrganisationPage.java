package com.VTiger.crm.objectRepositoryutility.OrganisationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility{

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organisationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement indus_dropdown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type_dropdown;
	
	@FindBy(id="phone")
	private WebElement phoneNoEdit;
	
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateNewOrganisation() {
		return organisationName;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getindus_dropdown() {
		return indus_dropdown;
	}
	public WebElement gettype_dropdown() {
		return type_dropdown;
	}
	public WebElement getphoneNoEdit() {
		return phoneNoEdit;
	}
	
	public void createOrgPage(String value) {
		organisationName.sendKeys(value);
		SaveBtn.click();
	}
	
	public void createOrgPageWithIndustry(WebDriver driver,String value,String industry,String type) {
		organisationName.sendKeys(value);
		select(indus_dropdown, industry);
		select(type_dropdown, type);
		SaveBtn.click();
	}
	
	public void createOrgWithPh(String value,String phno) {
		organisationName.sendKeys(value);
		phoneNoEdit.sendKeys(phno);
		SaveBtn.click();
	}
	
	}
