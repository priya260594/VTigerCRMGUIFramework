import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeTestNGAnotationTest {

	@AfterMethod
	public void configAM() {
		System.out.println("AM");
	}
	@AfterClass
	public void configAC() {
		System.out.println("AC");
	}
	@Test
	public void ContactTestD() {
		System.out.println("contact created with date");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("BM");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("AS");
	}
	
	@BeforeSuite
	public void configBS() {
		System.out.println("BS");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("BC");
	}
	@Test
	public void ContactTest() {
		System.out.println("contact created");
	}
}
