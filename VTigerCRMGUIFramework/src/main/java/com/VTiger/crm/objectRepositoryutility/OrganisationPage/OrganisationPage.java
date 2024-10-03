package com.VTiger.crm.objectRepositoryutility.OrganisationPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility{

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrganisation;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search_field")
	private WebElement searchcategoryDDn;

	@FindBy(name="submit")
	private WebElement submitBtn;
	
	//@FindBy(xpath="//a[@title='Organizations']")
	//private WebElement AllDisplayedorgName;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/descendant::span[@name='Accounts_listViewCountContainerName']")
	private WebElement totalPageCount;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/descendant::img[@src='themes/images/next.gif']")
	private WebElement nextBtn;
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateNewOrganisation() {
		return createNewOrganisation;
	}
	
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}
	
	public WebElement getsearchcategoryDDn() {
		return searchcategoryDDn;
	}
	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	/**public WebElement getAllDisplayedorgName() {
		return AllDisplayedorgName;
	}**/
	public WebElement gettotalPageCount() {
		return totalPageCount;
	}
	public WebElement getNextBtn() {
		return nextBtn;
	}
	

	public void creatingNewOrganisation() {
		createNewOrganisation.click();
	}
	public void deleteOrgName(WebDriver driver,String orgName) throws InterruptedException {
	searchBoxEdt.sendKeys(orgName);
	select(searchcategoryDDn, "Organization Name");
	submitBtn.click();
	driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[last()]/a[text()='del']")).click();
    switchingAlertAccept(driver);
}
	
	public void readAllOrgName(WebDriver driver) throws InterruptedException {
		String pageCount=totalPageCount.getText().replace("of ", "");
		List<WebElement> orgNames=new ArrayList<WebElement>();
		List<WebElement> allDisplayedorgName=driver.findElements(By.xpath("//a[@title='Organizations']"));

		for(int i=1;i<Integer.parseInt(pageCount);i++) {
		    orgNames.addAll(allDisplayedorgName);
			nextBtn.click();
			Thread.sleep(3000);
			}
			
		for(WebElement orgNam:orgNames) {
		System.out.println("The list of org names created are "+orgNam.getText());}
		
	}
	public void findOrgName(WebDriver driver) {
//		String countOfPage=driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::span[@name='Accounts_listViewCountContainerName']")).getText().replace("of ","");
//		WebElement nextBtn=driver.findElement(By.xpath("//table[@class='layerPopupTransport']/descendant::img[@src='themes/images/next_disabled.gif']"));
//		List<WebElement> orgNames=new ArrayList<WebElement>();
//		
//		for(int i=1;i<Integer.parseInt(countOfPage);i++) {
//			orgNames.add(AllDisplayedorgName);
//			nextBtn.click();
//		}
//		System.out.println("The list of org names created are "+orgname);
	}
}
