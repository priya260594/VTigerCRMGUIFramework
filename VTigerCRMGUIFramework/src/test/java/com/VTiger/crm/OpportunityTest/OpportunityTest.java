package com.VTiger.crm.OpportunityTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactInfoPage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactPage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.CreateNewContactPage;
import com.VTiger.crm.objectRepositoryutility.OpportunityPage.CreateNewOpportunityPage;
import com.VTiger.crm.objectRepositoryutility.OpportunityPage.OpportunityInfoPage;
import com.VTiger.crm.objectRepositoryutility.OpportunityPage.OpportunityPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.CreateNewOrganisationPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationInfoPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationPage;

public class OpportunityTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void createOpWithOrgTest() throws IOException, InterruptedException {
	
		String orgName=eLib.getDataFromExcelFile("Organization", 1, 2)+jLib.getRandomNumber();
		String OPNAME=eLib.getDataFromExcelFile("Opportunity", 1, 2);
		String ASSIGNEDTO=eLib.getDataFromExcelFile("Opportunity", 1, 3);
		String AfterAMonthDate=jLib.getRequiredYYYYMMdd(30);
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizationTab().click();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.creatingNewOrganisation();
		
		CreateNewOrganisationPage newOrg=new CreateNewOrganisationPage(driver);
		newOrg.createOrgPage(orgName);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		wLib.waitForElementVisible(driver, oip.getHeaderOrgName());
		
		hp.getOpportunitiesLnk().click();
		
		OpportunityPage op1=new OpportunityPage(driver);
		op1.getcreateOpportunity().click();
		
		
		CreateNewOpportunityPage newOpportunity=new CreateNewOpportunityPage(driver);
		newOpportunity.createOppor(driver, OPNAME, orgName, ASSIGNEDTO, AfterAMonthDate);
		
		Thread.sleep(10000);
		
		OpportunityInfoPage oIP=new OpportunityInfoPage(driver);
		oIP.verifyDisplayedOPNameTxt(OPNAME);
		oIP.verifyHeaderOpNameTxt(OPNAME);
		oIP.verifyRelatedToOrgTxt(orgName);
		oIP.verifyAssignedToTxt(ASSIGNEDTO);
		oIP.verifyCloseDateTxt(AfterAMonthDate);

			}
	@Test(groups="RegressionTest")
	public void createOPWithContactTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String ContName = eLib.getDataFromExcelFile("Opportunity", 4, 5) + jLib.getRandomNumber();
		String OPNAME = eLib.getDataFromExcelFile("Opportunity", 4, 2);
		String ASSIGNEDTO = eLib.getDataFromExcelFile("Opportunity", 4, 3);
		String SALESSTAGE = eLib.getDataFromExcelFile("Opportunity", 4, 4);
		String AfterAMonthDate = jLib.getRequiredYYYYMMdd(30);

		HomePage hp = new HomePage(driver);
		hp.getContactsTab().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		CreateNewContactPage newCont = new CreateNewContactPage(driver);
		newCont.CreateContact(ContName);

		ContactInfoPage cip = new ContactInfoPage(driver);
		wLib.waitForElementVisible(driver, cip.getheaderTxtLastName());

		hp.getOpportunitiesLnk().click();

		OpportunityPage op1 = new OpportunityPage(driver);
		op1.getcreateOpportunity().click();

		CreateNewOpportunityPage newOpportunity = new CreateNewOpportunityPage(driver);
		newOpportunity.createOpporWithCont(driver, OPNAME, ContName, ASSIGNEDTO, SALESSTAGE, AfterAMonthDate);

		Thread.sleep(10000);

		OpportunityInfoPage oIP = new OpportunityInfoPage(driver);
		oIP.verifyDisplayedOPNameTxt(OPNAME);
		oIP.verifyHeaderOpNameTxt(OPNAME);
		oIP.verifyRelatedToContTxt(ContName);
		oIP.verifyAssignedToTxt(ASSIGNEDTO);
		oIP.verifyCloseDateTxt(AfterAMonthDate);

	}

}
