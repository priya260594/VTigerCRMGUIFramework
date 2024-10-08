package com.VTiger.crm.contacttest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactInfoPage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactPage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.CreateNewContactPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.CreateNewOrganisationPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationInfoPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationPage;
@Listeners (com.VTiger.crm.ListenerUtility.ListImpClass.class)
public class ContactTest extends BaseClass {

	@Test(groups="SmokeTest")
	public void createContTest() throws IOException, InterruptedException {

		String lastName = eLib.getDataFromExcelFile("Contacts", 1, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactsTab().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		CreateNewContactPage newCont = new CreateNewContactPage(driver);
		newCont.CreateContact(lastName);

		ContactInfoPage cIP = new ContactInfoPage(driver);
		cIP.verifyDisplayedLastName(lastName);
		cIP.verifyHeaderLastName(lastName);

	}

	@Test(groups="RegressionTest")
	public void createContWithOrgTest() throws IOException, InterruptedException {

		String orgName = eLib.getDataFromExcelFile("Organization", 10, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("Contacts", 7, 2);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationTab().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.creatingNewOrganisation();

		CreateNewOrganisationPage newOrg = new CreateNewOrganisationPage(driver);
		newOrg.createOrgPage(orgName);

		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		wLib.waitForElementVisible(driver, oip.getHeaderOrgName());

		hp.getContactsTab().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		CreateNewContactPage newCont = new CreateNewContactPage(driver);
		newCont.createContactWithOrg(driver, lastName, orgName);

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.verifyOrgName(orgName);
		cip.verifyHeaderLastName(lastName);
	}

	@Test(groups="RegressionTest")
	public void createContWithSupportDateTest() throws IOException, InterruptedException {

		String actualDate = jLib.getSystemDate();
		String AfterAMonthDate = jLib.getRequiredYYYYMMdd(30);
		String lastName = eLib.getDataFromExcelFile("Contacts", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactsTab().click();

		ContactPage cont = new ContactPage(driver);
		cont.getCreateNewContact().click();

		CreateNewContactPage newCont = new CreateNewContactPage(driver);
		newCont.CreateContactWithSupportDate(lastName, actualDate, AfterAMonthDate);

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.verifySupportStartDate(actualDate);
		cip.verifySupportEndDate(AfterAMonthDate);
	}
}
