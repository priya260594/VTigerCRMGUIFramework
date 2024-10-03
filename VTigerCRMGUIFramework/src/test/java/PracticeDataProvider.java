import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.VTiger.crm.generic.fileutility.ExcelUtility;

public class PracticeDataProvider {
	@DataProvider
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
			obj[i][1]=eLib.getDataFromExcelFile("Sheet2", i+1, 1);
			}
		}
		return obj;
		
	}
		/**obj[0][0]="Apple iPhone 13 (128GB) - Starlight";
		obj[1][0]="Apple iPhone 14 (128 GB) - Blue";
		obj[2][0]="Apple iPhone 15 Pro (256 GB) - Natural Titanium";**/
		


}
