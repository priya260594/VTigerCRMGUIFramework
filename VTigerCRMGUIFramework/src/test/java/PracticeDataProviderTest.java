import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.VTiger.crm.generic.fileutility.ExcelUtility;

public class PracticeDataProviderTest {
	@Test(dataProviderClass=PracticeDataProvider.class,dataProvider="getPric")      //(dataProvider="getPric")
	public void AmazonPracticTest(String productName,String brandName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName,Keys.ENTER);
		//driver.findElement(By.id("nav-search-submit-button")).click();
		
		String x="//span[text()='"+brandName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']";
	    WebElement priceElement=driver.findElement(By.xpath(x));
	    String price=priceElement.getText();
	    System.out.println(price);
	    System.out.println("BrandName: "+brandName+"----------Price: "+price);
	    driver.quit();
	}

	/**@DataProvider
	public Object[][] getPric() throws EncryptedDocumentException, IOException{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount=eLib.getRowCount("Sheet2");
		int cellCount=eLib.getCellCount("Sheet2");
		System.out.println(rowCount);
		System.out.println(cellCount);
		Object[][] obj=new Object[rowCount][cellCount];
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
			obj[i][j]=eLib.getDataFromExcelFile("Sheet2", i+1, j);
//			obj[i][1]=eLib.getDataFromExcelFile("Sheet2", i+1, 1);
			}
		}
		
		/**obj[0][0]="Apple iPhone 13 (128GB) - Starlight";
		obj[1][0]="Apple iPhone 14 (128 GB) - Blue";
		obj[2][0]="Apple iPhone 15 Pro (256 GB) - Natural Titanium";**/
		
//		return obj;
		
//	} **/

}

