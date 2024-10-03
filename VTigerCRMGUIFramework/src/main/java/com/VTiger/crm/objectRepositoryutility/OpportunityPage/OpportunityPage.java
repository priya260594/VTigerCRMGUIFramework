package com.VTiger.crm.objectRepositoryutility.OpportunityPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {

	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement createOpportunity;
	
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getcreateOpportunity() {
		return createOpportunity;
	}
}
