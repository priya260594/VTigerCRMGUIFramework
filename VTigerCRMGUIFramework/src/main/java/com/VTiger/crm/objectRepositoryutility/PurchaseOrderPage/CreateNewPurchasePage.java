package com.VTiger.crm.objectRepositoryutility.PurchaseOrderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactsSelectionPage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.ProductLookUpPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorLookUpPage;
import com.VTiger.crm.objectRepositoryutility.servicePage.ServiceSelectionPage;

public class CreateNewPurchasePage extends WebDriverUtility {

	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subNameEdt;

	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img[@alt='Select']")
	private WebElement VendorLookUpImg;

	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img[@alt='Select']")
	private WebElement ContactLookUpImg;

	@FindBy(name = "bill_street")
	private WebElement addressEdt;

	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillAddress;

	@FindBy(id = "searchIcon1")
	private WebElement addItemImg;

	@FindBy(id = "qty1")
	private WebElement quantity;

	@FindBy(xpath = "//input[@value='Add Service']")
	private WebElement addServiceBtn;

	@FindBy(id = "searchIcon2")
	private WebElement addServiceImg;

	@FindBy(xpath = "//tr[@id='row2']/td[3]/input[@class='detailedViewTextBoxOn']")
	private WebElement secondItemQuantity;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewPurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubNameEdt() {
		return subNameEdt;
	}

	public WebElement getVendorLookUpImg() {
		return VendorLookUpImg;
	}

	public WebElement getContactLookUpImg() {
		return ContactLookUpImg;
	}

	public WebElement getAddressEdt() {
		return addressEdt;
	}

	public WebElement getCopyBillAddress() {
		return copyBillAddress;
	}

	public WebElement getAddItemImg() {
		return addItemImg;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getaddServiceBtn() {
		return addServiceBtn;
	}

	public WebElement getaddServiceImg() {
		return addServiceImg;
	}

	public WebElement getsecondItemQuantity() {
		return secondItemQuantity;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createPurchaseOrder(WebDriver driver, String subName, String vendorNam, String BillAddress,
			String ProdName, String qty) {
		subNameEdt.sendKeys(subName);
		VendorLookUpImg.click();
		SwitchingTabsUsingURL(driver, "module=Vendors&action");

		VendorLookUpPage vip = new VendorLookUpPage(driver);
		vip.vendorLookUpSearch(driver, vendorNam);
		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");

		addressEdt.sendKeys(BillAddress);
		copyBillAddress.click();

		addItemImg.click();
		SwitchingTabsUsingURL(driver, "module=Products&action");

		ProductLookUpPage plp = new ProductLookUpPage(driver);
		plp.clickParticularProduct(driver, ProdName);

		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");
		quantity.sendKeys(qty);
		saveBtn.click();

	}

	public void createPurchaseOrderWithCont(WebDriver driver, String subName, String vendorNam, String BillAddress,
			String ProdName, String qty, String contName) {
		subNameEdt.sendKeys(subName);
		VendorLookUpImg.click();
		SwitchingTabsUsingURL(driver, "module=Vendors&action");

		VendorLookUpPage vip = new VendorLookUpPage(driver);
		vip.vendorLookUpSearch(driver, vendorNam);
		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");

		ContactLookUpImg.click();
		SwitchingTabsUsingURL(driver, "module=Contacts&action");
		ContactsSelectionPage csp = new ContactsSelectionPage(driver);
		csp.selectParticularContactName(driver, contName);
		switchingAlertAccept(driver);
		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");

		addressEdt.sendKeys(BillAddress);
		copyBillAddress.click();

		addItemImg.click();
		SwitchingTabsUsingURL(driver, "module=Products&action");

		ProductLookUpPage plp = new ProductLookUpPage(driver);
		plp.clickParticularProduct(driver, ProdName);

		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");
		quantity.sendKeys(qty);
		saveBtn.click();

	}

	public void createPOWithContAndService(WebDriver driver, String subName, String vendorNam, String BillAddress,
			String ProdName, String qty, String contName, String ServiceName) {
		subNameEdt.sendKeys(subName);
		VendorLookUpImg.click();
		SwitchingTabsUsingURL(driver, "module=Vendors&action");

		VendorLookUpPage vip = new VendorLookUpPage(driver);
		vip.vendorLookUpSearch(driver, vendorNam);
		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");

		ContactLookUpImg.click();
		SwitchingTabsUsingURL(driver, "module=Contacts&action");
		ContactsSelectionPage csp = new ContactsSelectionPage(driver);
		csp.selectParticularContactName(driver, contName);
		switchingAlertAccept(driver);
		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");

		addressEdt.sendKeys(BillAddress);
		copyBillAddress.click();

		addItemImg.click();
		SwitchingTabsUsingURL(driver, "module=Products&action");

		ProductLookUpPage plp = new ProductLookUpPage(driver);
		plp.clickParticularProduct(driver, ProdName);

		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");
		quantity.sendKeys(qty);

		addServiceBtn.click();
		addServiceImg.click();
		SwitchingTabsUsingURL(driver, "module=Services&action");
		ServiceSelectionPage sp = new ServiceSelectionPage(driver);
		sp.clickParticularService(driver, ServiceName);
		SwitchingTabsUsingURL(driver, "module=PurchaseOrder&action");

		secondItemQuantity.sendKeys(qty);
		saveBtn.click();
	}
}
