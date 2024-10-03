package com.VTiger.crm.objectRepositoryutility.CampaignPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	@FindBy(xpath = "Create Campaign...")
	private WebElement newCampaignBtn;

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getnewCampaignBtn() {
		return newCampaignBtn;
	}
}
