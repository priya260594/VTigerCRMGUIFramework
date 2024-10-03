package com.VTiger.crm.objectRepositoryutility.OpportunityPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OpportunityInfoPage {
	
	SoftAssert sa=new SoftAssert();
	@FindBy(id="dtlview_Opportunity Name")
	private WebElement DisplayedOpporNametxt;

	@FindBy(className="dvHeaderText")
	private WebElement HeaderOpporNametxt;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement RelatedToOrgtxt;

	@FindBy(xpath="//a[@title='Contacts']")
	private WebElement RelatedToConttxt;
	
	@FindBy(id="dtlview_Assigned To")
	private WebElement AssignedToTxt;
	
	@FindBy(xpath="//td[text()='Expected Close Date']/following-sibling::td[@class='dvtCellInfo']")
	private WebElement CloseDateTxt;
	

public OpportunityInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}


public WebElement getDisplayedOpporNametxt() {
	return DisplayedOpporNametxt;
}


public WebElement getHeaderOpporNametxt() {
	return HeaderOpporNametxt;
}


public WebElement getRelatedToOrgtxt() {
	return RelatedToOrgtxt;
}

public WebElement getRelatedToConttxt() {
	return RelatedToConttxt;
}


public WebElement getAssignedToTxt() {
	return AssignedToTxt;
}


public WebElement getCloseDateTxt() {
	return CloseDateTxt;
} 

public void verifyDisplayedOPNameTxt(String OPNAME) {
	Assert.assertEquals(DisplayedOpporNametxt.getText(), OPNAME);
}

public void verifyHeaderOpNameTxt(String OPNAME) {
	boolean flag=HeaderOpporNametxt.getText().contains(OPNAME);
	Assert.assertTrue(flag);;
}

public void verifyRelatedToOrgTxt(String orgName) {
	Assert.assertEquals(RelatedToOrgtxt.getText().trim(), orgName);
}

public void verifyRelatedToContTxt(String ContactName) {
	Assert.assertEquals(RelatedToConttxt.getText(), ContactName);
}
public void verifyAssignedToTxt(String ASSIGNEDTO) {
	boolean flag=AssignedToTxt.getText().contains(ASSIGNEDTO);
	sa.assertTrue(flag);
	sa.assertAll();
}

public void verifyCloseDateTxt(String AfterAMonthDate){
	boolean flag=CloseDateTxt.getText().trim().contains(AfterAMonthDate);
	sa.assertTrue(flag);
	sa.assertAll();
}
}
