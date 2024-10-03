package SampleListenerTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.crm.BaseClass.BaseClass;

//@Listeners(com.VTiger.crm.ListenerUtility.ListImpClass.class)
public class InvoiceTest extends BaseClass {
	@Test   //(retryAnalyzer = com.VTiger.crm.ListenerUtility.RetryAnalyserImpClass.class)
	public void createInvoiceTest() {
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Home");
		System.out.println();
		System.out.println("create invoice test");
	}
	@Test
	public void createInvoiceWithContactTest() {}
	

}
