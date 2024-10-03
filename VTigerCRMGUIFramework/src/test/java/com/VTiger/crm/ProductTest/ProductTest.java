package com.VTiger.crm.ProductTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.CreateNewProductPage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.ProductInfoPage;
import com.VTiger.crm.objectRepositoryutility.ProductPage.ProductPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.CreateNewVendorPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorInfoPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorPage;

public class ProductTest extends BaseClass {
	@Test
	public void createProductTest() throws IOException, InterruptedException {
		String productName = eLib.getDataFromExcelFile("Products", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getproductsTab().click();

		ProductPage pp = new ProductPage(driver);
		pp.getCreateNewProduct().click();

		CreateNewProductPage newProduct = new CreateNewProductPage(driver);
		newProduct.createProduct(productName);

		ProductInfoPage pip = new ProductInfoPage(driver);
		pip.verifyDisplayedProductName(productName);
		pip.verifyHeaderProductName(productName);
	}

	@Test
	public void ProdWithVendorTest() throws IOException, InterruptedException {

		String vendorNam = eLib.getDataFromExcelFile("Products", 4, 3) + jLib.getRandomNumber();
		String productName = eLib.getDataFromExcelFile("Products", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickVendor(driver);

		VendorPage vp = new VendorPage(driver);
		vp.getnewVendorBtn().click();

		CreateNewVendorPage newVendor = new CreateNewVendorPage(driver);
		newVendor.createVendor(vendorNam);

		System.out.println("Vendor Created");
		// vendor created

		VendorInfoPage vip = new VendorInfoPage(driver);
		wLib.waitForElementVisible(driver, vip.getHeaderVendorName());

		hp.getproductsTab().click();
		ProductPage pp = new ProductPage(driver);
		pp.getCreateNewProduct().click();

		CreateNewProductPage newproduct = new CreateNewProductPage(driver);
		newproduct.createProduct(driver, productName, vendorNam);

		ProductInfoPage pip = new ProductInfoPage(driver);
		pip.verifyHeaderProductName(productName);
		pip.verifyVendorName(vendorNam);

	}

}
