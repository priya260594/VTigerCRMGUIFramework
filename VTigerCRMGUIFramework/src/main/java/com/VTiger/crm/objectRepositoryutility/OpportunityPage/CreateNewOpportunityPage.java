package com.VTiger.crm.objectRepositoryutility.OpportunityPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactsSelectionPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationSelectionPage;

public class CreateNewOpportunityPage extends WebDriverUtility {

	@FindBy(name = "potentialname")
	private WebElement opporNameEdt;

	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img[@alt='Select']")
	private WebElement AddOrgBtn;

	@FindBy(xpath = "//input[@name='closingdate']")
	private WebElement ExpCloseDate;

	@FindBy(xpath = "//select[@name='sales_stage']")
	private WebElement salesStageDDWN;

	@FindBy(xpath = "//td[@class='dvtCellInfo']/input[@type='radio' and @value='T']")
	private WebElement AssignRadioBtn;

	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement AssignToDropDown;

	@FindBy(name = "sales_stage")
	private WebElement salesStageDropDown;

	@FindBy(id = "related_to_type")
	private WebElement RelatedToDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpporNameEdt() {
		return opporNameEdt;
	}

	public WebElement getAddOrgBtn() {
		return AddOrgBtn;
	}

	public WebElement getExpCloseDate() {
		return ExpCloseDate;
	}

	public WebElement getsalesStageDDWN() {
		return salesStageDDWN;
	}

	public WebElement getAssignToDropDown() {
		return AssignToDropDown;
	}

	public WebElement getRelatedToDropDown() {
		return RelatedToDropDown;
	}

	public WebElement getsaveBtn() {
		return saveBtn;
	}

	public WebElement getAssignRadioBtn() {
		return AssignRadioBtn;
	}

	public WebElement getsalesStageDropDown() {
		return salesStageDropDown;
	}

	public void createOppor(WebDriver driver, String OPNAME, String orgName, String ASSIGNEDTO, String AfterAMonthDate)
			throws InterruptedException {
		opporNameEdt.sendKeys(OPNAME);
		AddOrgBtn.click();
		SwitchingTabsUsingURL(driver, "module=Accounts&action");

		OrganisationSelectionPage osp = new OrganisationSelectionPage(driver);
		osp.OrgSelectPage(driver, orgName);
		SwitchingTabsUsingURL(driver, "module=Potentials&action");

		AssignRadioBtn.click();
		select(AssignToDropDown, ASSIGNEDTO);
		ExpCloseDate.clear();
		ExpCloseDate.sendKeys(AfterAMonthDate);
		saveBtn.click();
	}

	public void createOpporWithCont(WebDriver driver, String OPNAME, String ContName, String ASSIGNEDTO,
			String SALESSTAGE, String AfterAMonthDate) throws InterruptedException {
		opporNameEdt.sendKeys(OPNAME);
		selectByValue(RelatedToDropDown, "Contacts");
		AddOrgBtn.click();
		SwitchingTabsUsingURL(driver, "module=Contacts&action");

		ContactsSelectionPage csp = new ContactsSelectionPage(driver);
		csp.selectParticularContactName(driver, ContName);

		SwitchingTabsUsingURL(driver, "module=Potentials&action");

		AssignRadioBtn.click();
		select(AssignToDropDown, ASSIGNEDTO);
		ExpCloseDate.clear();
		ExpCloseDate.sendKeys(AfterAMonthDate);
		selectByValue(salesStageDropDown, SALESSTAGE);
		saveBtn.click();
	}
//	public void createOppWithSales(WebDriver driver,String OPNAME, String ContName, String SALESSTAGE) throws InterruptedException {
//		opporNameEdt.sendKeys(OPNAME);
//		selectByValue(RelatedToDropDown, "Contacts");
//		AddOrgBtn.click();
//		SwitchingTabsUsingURL(driver, "module=Contacts&action");
//
//		ContactsSelectionPage csp = new ContactsSelectionPage(driver);
//		csp.selectParticularContactName(driver, ContName);
//
//		SwitchingTabsUsingURL(driver, "module=Potentials&action");
//
//		selectByValue(salesStageDropDown, SALESSTAGE);
//		saveBtn.click();
//		
//	}
//
}
