package com.VTiger.crm.objectRepositoryutility.ContactsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationSelectionPage;

public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@alt='Select']")
	private WebElement Organisation_Selection;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;

	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;


	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrganisation_Selection() {
		return Organisation_Selection;
	}

	public WebElement getsupportStartDate() {
		return supportStartDate;
	}

	public WebElement getsupportEndDate() {
		return supportEndDate;
	}

	public void CreateContact(String lN) {
		LastNameEdt.sendKeys(lN);
		SaveBtn.click();
	}

//
	public void CreateContactWithSupportDate(String lN, String actualDate, String afterAMonthDate) {
		LastNameEdt.sendKeys(lN);
		supportStartDate.clear();
		supportStartDate.sendKeys(actualDate);
		supportEndDate.clear();
		supportEndDate.sendKeys(afterAMonthDate);
		SaveBtn.click();
	}

	public void createContactWithOrg(WebDriver driver,String lastName, String orgName) {
        LastNameEdt.sendKeys(lastName);
		Organisation_Selection.click();
        SwitchingTabsUsingURL(driver, "module=Accounts&action");
        OrganisationSelectionPage osp = new OrganisationSelectionPage(driver);
		osp.OrgSelectPage(driver,orgName);
		SwitchingTabsUsingURL(driver, "Contacts&action");
		SaveBtn.click();
	}

}
