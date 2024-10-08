package com.VTiger.crm.orgTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.CreateNewOrganisationPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationInfoPage;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationPage;

public class CreateOrgTest1 extends BaseClass {
	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		/**
		 * FileUtility fLib=new FileUtility(); String
		 * BROWSER=fLib.getDataFromPropertyFile("browser"); String
		 * URL=fLib.getDataFromPropertyFile("url"); String
		 * USERNAME=fLib.getDataFromPropertyFile("username"); String
		 * PASSWORD=fLib.getDataFromPropertyFile("password");
		 * 
		 * WebDriver driver; if(BROWSER=="chrome") { driver=new ChromeDriver(); }else
		 * if(BROWSER=="firefox") { driver=new FirefoxDriver(); }else
		 * if(BROWSER=="Edge") { driver=new EdgeDriver(); }else { driver=new
		 * FirefoxDriver(); } //login to app driver.get(URL);
		 * wLib.WaitForPageToLoad(driver); LoginPage lp=new LoginPage(driver);
		 * //LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		 * //lp.getUsernameEdit().sendKeys("admin");
		 * lp.loginToApplication(USERNAME,PASSWORD);
		 **/

		String orgName = eLib.getDataFromExcelFile("Organization", 1, 2) + jLib.getRandomNumber();
		hp.getOrganizationTab().click();

		OrganisationPage orgPage = new OrganisationPage(driver);
		orgPage.creatingNewOrganisation();

		CreateNewOrganisationPage newOrg = new CreateNewOrganisationPage(driver);
		newOrg.createOrgPage(orgName);

		OrganisationInfoPage orgInfo = new OrganisationInfoPage(driver);
		orgInfo.verifyHeaderOrgName(orgName);
		orgInfo.verifyDisplayedOrgName(orgName);

		// hp.signOutOfApp();
		// Thread.sleep(4000);
		// driver.close();
		/**
		 * String createdOrgName=driver.findElement(By.id("mouseArea_Organization
		 * Name")).getText(); String
		 * displayedOrgName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 * 
		 * if(createdOrgName.equals(value)) { System.out.println("Expected Test has been
		 * created"); }else { System.out.println("Expected Test has been not created");
		 * } if(displayedOrgName.contains(value)) { System.out.println("Test is
		 * passed"); }else { System.out.println("Test is failed"); } WebElement
		 * element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 * wLib.mouseMoveToElementOp(driver, element);
		 * 
		 * driver.findElement(By.linkText("Sign Out")).click();
		 **/

	}
}