package com.VTiger.crm.objectRepositoryutility.OrganisationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganisationInfoPage extends WebDriverUtility {
	SoftAssert sa=new SoftAssert();

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement createdOrgName;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement HeaderOrgName;

	@FindBy(id = "mouseArea_Industry")
	private WebElement indus_txt;

	@FindBy(id = "dtlview_Type")
	private WebElement type_txt;

	@FindBy(id = "dtlview_Phone")
	private WebElement phno_txt;

	public OrganisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatedOrgName() {
		return createdOrgName;
	}

	public WebElement getHeaderOrgName() {
		return HeaderOrgName;
	}

	public WebElement getindus_txt() {
		return indus_txt;
	}

	public WebElement getphno_txt() {
		return phno_txt;
	}

	public WebElement gettype_txt() {
		return type_txt;
	}

	public void verifyHeaderOrgName(String orgName) {
		boolean flag=HeaderOrgName.getText().contains(orgName);
		Assert.assertTrue(flag);
	}

	public void verifyDisplayedOrgName(String orgName) {
		Assert.assertEquals(createdOrgName.getText().trim(), orgName);
	}

	public void verifyIndustryTypeDDn(String industry_type) {
		sa.assertEquals(indus_txt.getText(), industry_type);
		sa.assertAll();
	}

	public void verifyTypeDdn(String type) {
		sa.assertEquals(type_txt.getText(), type);
		sa.assertAll();
	}

	public void verifyPhoneNoTxt(String phoneNo) {
		sa.assertEquals(phno_txt.getText(), phoneNo);
		sa.assertAll();
	}


	
}
