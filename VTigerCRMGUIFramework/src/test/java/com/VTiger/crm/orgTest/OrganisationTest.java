package com.VTiger.crm.orgTest;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.generic.webdriverutility.UtilityClassObject;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.CreateNewOrganisationPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationInfoPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationPage;
import com.aventstack.extentreports.Status;

@Listeners(com.VTiger.crm.ListenerUtility.ListImpClass.class)
public class OrganisationTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void createOrgTest() throws IOException, InterruptedException {
		String orgName = eLib.getDataFromExcelFile("Organization", 1, 2) + jLib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		hp.getOrganizationTab().click();

		UtilityClassObject.getTest().log(Status.INFO, "click new org page");
		OrganisationPage orgPage = new OrganisationPage(driver);
		orgPage.creatingNewOrganisation();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new org page");
        CreateNewOrganisationPage newOrg = new CreateNewOrganisationPage(driver);
		newOrg.createOrgPage(orgName);
		
		UtilityClassObject.getTest().log(Status.INFO, "org info page is displayed");
		OrganisationInfoPage orgInfo = new OrganisationInfoPage(driver);
		orgInfo.verifyHeaderOrgName(orgName);
		orgInfo.verifyDisplayedOrgName(orgName);
	}

	@Test(groups="RegressionTest")
	public void createOrgWithIndusTest() throws IOException, InterruptedException {

		String orgName = eLib.getDataFromExcelFile("Organization", 4, 2) + jLib.getRandomNumber();
		String industry_type = eLib.getDataFromExcelFile("Organization", 4, 3);
		String type = eLib.getDataFromExcelFile("Organization", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationTab().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.creatingNewOrganisation();

		CreateNewOrganisationPage newOrg = new CreateNewOrganisationPage(driver);
		newOrg.createOrgPageWithIndustry(driver, orgName, industry_type, type);

		OrganisationInfoPage oIp = new OrganisationInfoPage(driver);
		oIp.verifyIndustryTypeDDn(industry_type);
		oIp.verifyTypeDdn(type);

	}

	@Test(groups="RegressionTest")
	public void createOrgPhoneNoTest() throws InterruptedException, IOException {

		String orgName = eLib.getDataFromExcelFile("Organization", 7, 2) + jLib.getRandomNumber();
		String phoneNo = eLib.getDataFromExcelFile("Organization", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationTab().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.creatingNewOrganisation();

		CreateNewOrganisationPage newOrg = new CreateNewOrganisationPage(driver);
		newOrg.createOrgWithPh(orgName, phoneNo);

		OrganisationInfoPage oIP = new OrganisationInfoPage(driver);
		oIP.verifyPhoneNoTxt(phoneNo);
		oIP.verifyHeaderOrgName(orgName);

	}

	@Test(groups="RegressionTest")
	public void DeleteOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String orgName = eLib.getDataFromExcelFile("Organization", 13, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationTab().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateNewOrganisation().click();

		CreateNewOrganisationPage newOrg = new CreateNewOrganisationPage(driver);
		newOrg.createOrgPage(orgName);

		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		wLib.waitForElementVisible(driver, oip.getHeaderOrgName());
		hp.getOrganizationTab().click();

		op.deleteOrgName(driver, orgName);
		System.out.println("Organisation deleted");    
		
	}

}

