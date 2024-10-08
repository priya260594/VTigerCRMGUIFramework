package com.VTiger.crm.VendorTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.ObjectRepositories.HomePage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.CreateNewVendorPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorInfoPage;
import com.VTiger.crm.objectRepositoryutility.VendorsPage.VendorPage;
@Listeners(com.VTiger.crm.ListenerUtility.ListImpClass.class)
public class CreateVendorTest extends BaseClass{
	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		String vendorNam=eLib.getDataFromExcelFile("Vendors", 1, 2)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickVendor(driver);
		
		VendorPage vp=new VendorPage(driver);
		vp.getnewVendorBtn().click();
	
		CreateNewVendorPage newVendor=new CreateNewVendorPage(driver);
		newVendor.createVendor(vendorNam);
		
		//Vendor created
		//validation
		VendorInfoPage vip= new VendorInfoPage(driver);
		vip.verifyDisplayedVendorName(vendorNam);
		vip.verifyHeaderVendorName(vendorNam);
		
		
	}	
	}
	

