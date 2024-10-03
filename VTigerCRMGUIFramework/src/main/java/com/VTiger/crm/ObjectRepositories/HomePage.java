package com.VTiger.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText="Organizations")
    private WebElement organizationTab;
	
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Contacts']")
	private WebElement contactsTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLnk;
	
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='More']")
	private WebElement moreLnk;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLnk;

	@FindBy(linkText="Campaigns")
	private WebElement CampaignLnk;
	
	@FindBy(linkText="Purchase Order")
	private WebElement PurchaseOrderLnk;
	
	@FindBy(linkText="Products")
    private WebElement productsTab;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Services")
	private WebElement ServiceLnk;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrganizationTab() {
		return organizationTab;
	}
	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getAdministratorLnk() {
		return administratorLnk;
	}
	public WebElement getmoreLnk() {
		return moreLnk;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	public WebElement getvendorLnk() {
		return vendorLnk;
	}
	public WebElement getproductsTab() {
		return productsTab;
	}
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	public WebElement getCampaignLnk() {
		return CampaignLnk;
	}
	public WebElement getPurchaseOrderLnk() {
		return PurchaseOrderLnk;
	}
	public WebElement getServiceLnk() {
		return ServiceLnk;
	}
	//business libraries
	
	public void signOutOfApp(WebDriver driver) {
		mouseMoveToElementOp(driver, administratorLnk);
		//Actions act=new Actions(driver);
		//act.moveToElement(administratorLnk).perform();
		signOutBtn.click();
	}
	public void clickVendor(WebDriver driver) {
		mouseMoveToElementOp(driver, moreLnk);
		vendorLnk.click();
		}
	public void clickCampaign(WebDriver driver) {
		mouseMoveToElementOp(driver, moreLnk);
		CampaignLnk.click();
		}
	public void clickPurchaseOrderLnk(WebDriver driver) {
		mouseMoveToElementOp(driver, moreLnk);
		PurchaseOrderLnk.click();
		}
	public void clickServiceLnk(WebDriver driver) {
		mouseMoveToElementOp(driver, moreLnk);
		ServiceLnk.click();
		}
}
