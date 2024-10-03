package com.VTiger.crm.objectRepositoryutility.ContactsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {

	SoftAssert sa=new SoftAssert();
	
	@FindBy(id="dtlview_Last Name")
	private WebElement displayedLastNametxt;
	
	@FindBy(className="dvHeaderText")
	private WebElement headerTxtLastName;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgName_Txt;
	

	@FindBy(id="dtlview_Support End Date")
	private WebElement displayedEndDate;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement displayedStartDate;
	
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public WebElement getdisplayedLastNametxt() {
		return displayedLastNametxt;
	}
	
public WebElement getheaderTxtLastName() {
		return headerTxtLastName;
	}
public WebElement getorgName_Txt() {
	return orgName_Txt;
}

public WebElement getDisplayedEndDate() {
	return displayedEndDate;
}

public WebElement getDisplayedStartDate() {
	return displayedStartDate;
}

public void verifyDisplayedLastName(String lastName) {
	//Assert.assertEquals(displayedLastNametxt.getText(), lastName);
	sa.assertEquals(displayedLastNametxt.getText(), lastName);
	sa.assertAll();
}

public void verifyHeaderLastName(String lastName) {
	
	boolean flag=headerTxtLastName.getText().contains(lastName);
	Assert.assertTrue(flag);
}

public void verifyOrgName(String orgName) {
	Assert.assertEquals(orgName_Txt.getText().trim(), orgName);
}

public void verifySupportEndDate(String AfterAMonthDate) {
	Assert.assertEquals(displayedEndDate.getText(), AfterAMonthDate);
}

public void verifySupportStartDate(String actualDate) {
	sa.assertEquals(displayedStartDate.getText(), actualDate);
	sa.assertAll();
	}
}
