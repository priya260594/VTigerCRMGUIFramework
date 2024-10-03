package com.VTiger.crm.BaseClass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.ObjectRepositories.LoginPage;
import com.VTiger.crm.generic.databaseutility.DatabaseUtility;
import com.VTiger.crm.generic.fileutility.ExcelUtility;
import com.VTiger.crm.generic.fileutility.FileUtility;
import com.VTiger.crm.generic.javautility.JavaUtility;
import com.VTiger.crm.generic.webdriverutility.UtilityClassObject;
import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {

	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;//for listener class-step-1
	public HomePage hp;
		
	@BeforeSuite(groups={"SmokeTest","RegressionTest"})
	public void configAS() throws SQLException {
		dLib.getConnection();
		System.out.println("Database connected==Report configuration");

	}
	
	//@BeforeTest
	//@Parameters("browser")
	@BeforeClass (groups={"SmokeTest","RegressionTest"})
	public void configBC(/***String browser***/) throws IOException {
		String BROWSER=fLib.getDataFromPropertyFile("browser");
		//String BROWSER=browser;
		System.out.println(BROWSER);
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("Edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
  sdriver=driver; //for listener class-step-2
 UtilityClassObject.setDriver(sdriver); //utility class object
 
		System.out.println("Browser launched");
	}
	
	
	@BeforeMethod(groups={"SmokeTest","RegressionTest"})
	public void configAM() throws IOException {
		hp=new HomePage(driver);
		String URL=fLib.getDataFromPropertyFile("url");
		String USERNAME=fLib.getDataFromPropertyFile("username");
		String PASSWORD=fLib.getDataFromPropertyFile("password");
		
		driver.get(URL);
		wLib.WaitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("Login to app");
	}

	@AfterMethod(groups={"SmokeTest","RegressionTest"})
	public void configBM() {
		
        hp.signOutOfApp(driver);
		System.out.println("logout from app");
	}
	
	//@AfterTest
	@AfterClass(groups={"SmokeTest","RegressionTest"})
	public void configAC() {
		driver.quit();
		System.out.println("Browser closed"); }
	
	@AfterSuite(groups={"SmokeTest","RegressionTest"})
	public void configBS() throws SQLException {
		dLib.closeConnection();
		System.out.println("Database disconnected==Report backup");
	
	}
	
	
}
