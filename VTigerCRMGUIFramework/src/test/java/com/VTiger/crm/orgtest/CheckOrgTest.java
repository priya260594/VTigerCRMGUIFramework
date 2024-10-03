package com.VTiger.crm.orgtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.ObjectRepositories.LoginPage;
import com.VTiger.crm.generic.fileutility.ExcelUtility;
import com.VTiger.crm.generic.fileutility.FileUtility;
import com.VTiger.crm.generic.javautility.JavaUtility;
import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
import com.VTiger.crm.objectRepositoryutility.OrganisationPage.OrganisationPage;

public class CheckOrgTest {
	@Test
	public void checkOrgTest() throws IOException, InterruptedException {
		FileUtility fLib=new FileUtility();
	    ExcelUtility eLib=new ExcelUtility();
	    WebDriverUtility wLib=new WebDriverUtility();
	    
		String BROWSER=fLib.getDataFromPropertyFile("browser");
		String URL=fLib.getDataFromPropertyFile("url");
		String USERNAME=fLib.getDataFromPropertyFile("username");
		String PASSWORD=fLib.getDataFromPropertyFile("password");
		
	    JavaUtility jLib=new JavaUtility();
		int rand=jLib.getRandomNumber();

		String orgName="facebook_1959914090";

		WebDriver driver;
		if(BROWSER=="chrome") {
			driver=new ChromeDriver();
		}else if(BROWSER=="firefox") {
			driver=new FirefoxDriver();
		}else if(BROWSER=="Edge") {
			driver=new EdgeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		//login to app
		driver.get(URL);
		wLib.WaitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		//LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		//lp.getUsernameEdit().sendKeys("admin");
		lp.loginToApplication(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizationTab().click();
		
//	OrganisationPage orgPage=new OrganisationPage(driver);
//		orgPage.readAllOrgName(driver);
		PageFactory.initElements(driver, CheckOrgTest.class);
		String countOfPage=driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::span[@name='Accounts_listViewCountContainerName']")).getText().replace("of ","");
		List<WebElement> orgNames=new ArrayList<WebElement>();
		List<WebElement> allDisplayedorgName=driver.findElements(By.xpath("//a[@title='Organizations']"));

		for(int i=1;i<Integer.parseInt(countOfPage);i++) {
			try{orgNames.addAll(allDisplayedorgName);
				driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::img[@src='themes/images/next.gif']")).click();}
			catch(Exception e) {Thread.sleep(3000);
			e.printStackTrace();}
			
			}
			
		for(WebElement orgNam:orgNames) {
		System.out.println("The list of org names created are "+orgNam.getText());}
		
/**		
		//List<WebElement> AllDisplayedorgName=driver.findElements(By.xpath("//a[@title='Organizations']"));
		String countOfPage=driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::span[@name='Accounts_listViewCountContainerName']")).getText().replace("of ","");
		System.out.println(countOfPage);
		WebElement nextBtn=driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::img[@src='themes/images/next.gif']"));
//		List<WebElement> orgNames=new ArrayList<WebElement>();
		
		for(int i=1;i<Integer.parseInt(countOfPage);i++) {
		    //orgNames.addAll(AllDisplayedorgName);
			try{driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::img[@src='themes/images/next.gif']")).click();}
			catch(Exception e) {Thread.sleep(3000);
			e.printStackTrace();}
			
		}
		//for(WebElement orgNam:orgNames)
		//System.out.println("The list of org names created are "+orgNam.getText());
		//tr[@class='lvtColData']/td/a[@title='Organizations']
	
		/**List<WebElement> AllOrgName=driver.findElements(By.xpath("//a[@title='Organizations']"));
		for(WebElement orgNam:AllOrgName) {
			System.out.println(orgNam.getText());
		}  **/
	Thread.sleep(3000);	
	hp.signOutOfApp(driver);
	driver.quit();
		
		
		
	}

}
