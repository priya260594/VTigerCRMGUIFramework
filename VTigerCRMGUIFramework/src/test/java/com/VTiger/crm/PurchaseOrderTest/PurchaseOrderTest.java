package com.VTiger.crm.PurchaseOrderTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactInfoPage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.ContactPage;
import com.VTiger.crm.objectRepositoryutility.ContactsPage.CreateNewContactPage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.CreateNewProductPage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.ProductInfoPage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.ProductPage;
import com.VTiger.crm.objectRepositoryutility.PurchaseOrderPage.CreateNewPurchasePage;
import com.VTiger.crm.objectRepositoryutility.PurchaseOrderPage.PurchaseOrderInfoPage;
import com.VTiger.crm.objectRepositoryutility.PurchaseOrderPage.PurchasePage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.CreateNewVendorPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorInfoPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorPage;
import com.VTiger.crm.objectRepositoryutility.servicePage.CreateNewServicePage;
import com.VTiger.crm.objectRepositoryutility.servicePage.ServiceInfoPage;
import com.VTiger.crm.objectRepositoryutility.servicePage.ServicePage;

public class PurchaseOrderTest extends BaseClass{
	@Test
	public void createPurchaseTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String vendorNam = eLib.getDataFromExcelFile("Purchase_Order", 1, 2) + jLib.getRandomNumber();
		String prodName = eLib.getDataFromExcelFile("Purchase_Order", 1, 3) + jLib.getRandomNumber();
		String quantity = eLib.getDataFromExcelFile("Purchase_Order", 1, 4);
		String subName = eLib.getDataFromExcelFile("Purchase_Order", 1, 1);
		String BillAddress = eLib.getDataFromExcelFile("Purchase_Order", 1, 5);

		hp.clickVendor(driver);
		VendorPage vp = new VendorPage(driver);
		vp.getnewVendorBtn().click();

		CreateNewVendorPage newVendor = new CreateNewVendorPage(driver);
		newVendor.createVendor(vendorNam);

		VendorInfoPage vip = new VendorInfoPage(driver);
		wLib.waitForElementVisible(driver, vip.getHeaderVendorName());
		System.out.println("=================Vendor created=====================");

		hp.getproductsTab().click();

		ProductPage pp = new ProductPage(driver);
		pp.getCreateNewProduct().click();

		CreateNewProductPage newProduct = new CreateNewProductPage(driver);
		newProduct.createProdNameWithQty(prodName, quantity);
		

		ProductInfoPage pip = new ProductInfoPage(driver);
		wLib.waitForElementVisible(driver, pip.getHeaderProductName());
		System.out.println("=================Products created=====================");

		hp.clickPurchaseOrderLnk(driver);

		PurchasePage pup = new PurchasePage(driver);
		pup.getnewPurchaseOrder().click();

		CreateNewPurchasePage cpp = new CreateNewPurchasePage(driver);
		cpp.createPurchaseOrder(driver, subName, vendorNam, BillAddress, prodName, quantity);

		PurchaseOrderInfoPage poip = new PurchaseOrderInfoPage(driver);
		poip.verifydisplayedSubName(subName);
		poip.verifyheaderSubName(subName);
		poip.verifyVendorName(vendorNam);
		poip.verifyDisplayedBillAddress(BillAddress);
		poip.verifyDisplayedShippingAddress(BillAddress);
		poip.verifyProductName(driver, prodName);
		poip.verifyQuantity(quantity);

	}
	@Test
	public void createPurchaseWithContTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String vendorNam = eLib.getDataFromExcelFile("Purchase_Order", 4, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("Purchase_Order", 4, 3) + jLib.getRandomNumber();
		String prodName = eLib.getDataFromExcelFile("Purchase_Order", 4, 4) + jLib.getRandomNumber();
		String quantity = eLib.getDataFromExcelFile("Purchase_Order", 4, 5);
		String subName = eLib.getDataFromExcelFile("Purchase_Order", 4, 1);
		String BillAddress = eLib.getDataFromExcelFile("Purchase_Order", 4, 6);

		hp.clickVendor(driver);
		VendorPage vp = new VendorPage(driver);
		vp.getnewVendorBtn().click();

		CreateNewVendorPage newVendor = new CreateNewVendorPage(driver);
		newVendor.createVendor(vendorNam);

		VendorInfoPage vip = new VendorInfoPage(driver);
		wLib.waitForElementVisible(driver, vip.getHeaderVendorName());
		System.out.println("=================Vendor created=====================");

        hp.getContactsTab().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContact().click();
		
		CreateNewContactPage newCont=new CreateNewContactPage(driver);
		newCont.CreateContact(lastName);
		
		ContactInfoPage cIP=new ContactInfoPage(driver);
		wLib.waitForElementVisible(driver, cIP.getheaderTxtLastName());
		System.out.println("=================Contacts created=====================");

		hp.getproductsTab().click();

		ProductPage pp = new ProductPage(driver);
		pp.getCreateNewProduct().click();

		CreateNewProductPage newProduct = new CreateNewProductPage(driver);
		newProduct.createProdNameWithQty(prodName, quantity);
		

		ProductInfoPage pip = new ProductInfoPage(driver);
		wLib.waitForElementVisible(driver, pip.getHeaderProductName());
		System.out.println("=================Products created=====================");

		hp.clickPurchaseOrderLnk(driver);

		PurchasePage pup = new PurchasePage(driver);
		pup.getnewPurchaseOrder().click();

		CreateNewPurchasePage cpp = new CreateNewPurchasePage(driver);
		cpp.createPurchaseOrderWithCont(driver, subName, vendorNam, BillAddress, prodName, quantity,lastName);

		PurchaseOrderInfoPage poip = new PurchaseOrderInfoPage(driver);
		poip.verifydisplayedSubName(subName);
		poip.verifyheaderSubName(subName);
		poip.verifyVendorName(vendorNam);
		poip.verifyContactName(lastName);
		poip.verifyDisplayedBillAddress(BillAddress);
		poip.verifyDisplayedShippingAddress(BillAddress);
		poip.verifyProductName(driver, prodName);
		poip.verifyQuantity(quantity);
}
	@Test
	public void createPurchaseWithServiceTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String vendorNam = eLib.getDataFromExcelFile("Purchase_Order", 7, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("Purchase_Order", 7, 3) + jLib.getRandomNumber();
		String prodName = eLib.getDataFromExcelFile("Purchase_Order", 7, 4) + jLib.getRandomNumber();
		String quantity = eLib.getDataFromExcelFile("Purchase_Order", 7, 5);
		String subName = eLib.getDataFromExcelFile("Purchase_Order", 7, 1);
		String BillAddress = eLib.getDataFromExcelFile("Purchase_Order", 7, 6);
		String serviceName=eLib.getDataFromExcelFile("Purchase_Order", 7, 7)+ jLib.getRandomNumber();
		String serviceCategory=eLib.getDataFromExcelFile("Purchase_Order", 7, 8);
		
		
		hp.clickServiceLnk(driver);
		
		ServicePage pp=new ServicePage(driver);
		pp.getnewServicePage().click();
		
		CreateNewServicePage csp=new CreateNewServicePage(driver);
		csp.servicePage(driver, serviceName, serviceCategory);
		
		ServiceInfoPage sip=new ServiceInfoPage(driver);
		wLib.waitForElementVisible(driver, sip.getHeaderServiceName());
		System.out.println("=================Service created=====================");
		
		hp.clickVendor(driver);
		VendorPage vp = new VendorPage(driver);
		vp.getnewVendorBtn().click();

		CreateNewVendorPage newVendor = new CreateNewVendorPage(driver);
		newVendor.createVendor(vendorNam);

		VendorInfoPage vip = new VendorInfoPage(driver);
		wLib.waitForElementVisible(driver, vip.getHeaderVendorName());
		System.out.println("=================Vendor created=====================");

        hp.getContactsTab().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContact().click();
		
		CreateNewContactPage newCont=new CreateNewContactPage(driver);
		newCont.CreateContact(lastName);
		
		ContactInfoPage cIP=new ContactInfoPage(driver);
		wLib.waitForElementVisible(driver, cIP.getheaderTxtLastName());
		System.out.println("=================Contacts created=====================");

		hp.getproductsTab().click();

		ProductPage prop = new ProductPage(driver);
		prop.getCreateNewProduct().click();

		CreateNewProductPage newProduct = new CreateNewProductPage(driver);
		newProduct.createProdNameWithQty(prodName, quantity);
		

		ProductInfoPage pip = new ProductInfoPage(driver);
		wLib.waitForElementVisible(driver, pip.getHeaderProductName());
		System.out.println("=================Products created=====================");

		hp.clickPurchaseOrderLnk(driver);

		PurchasePage pup = new PurchasePage(driver);
		pup.getnewPurchaseOrder().click();

		CreateNewPurchasePage cpp = new CreateNewPurchasePage(driver);
		cpp.createPOWithContAndService(driver, subName, vendorNam, BillAddress, prodName, quantity, lastName, serviceName);
	

		PurchaseOrderInfoPage poip = new PurchaseOrderInfoPage(driver);
		poip.verifydisplayedSubName(subName);
		poip.verifyheaderSubName(subName);
		poip.verifyVendorName(vendorNam);
		poip.verifyContactName(lastName);
		poip.verifyDisplayedBillAddress(BillAddress);
		poip.verifyDisplayedShippingAddress(BillAddress);
		poip.verifyProductName(driver, prodName);
		poip.verifyQuantity(quantity);
		poip.verifyServiceName(serviceName);
}


}
