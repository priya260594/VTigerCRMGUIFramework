package com.VTiger.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VTiger.crm.generic.javautility.JavaUtility;

public class WebDriverUtility {

//Specifying Wait statements
public void WaitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
}

public void waitForElementToBeClick(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void waitForElementVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitAlertPresent(WebDriver driver,List<WebElement> elements) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.until(ExpectedConditions.visibilityOfAllElements(elements));
}

/**public void fluentWaitStatement(WebDriver driver,WebElement element) {
	FluentWait wait=new FluentWait(driver);
	wait.pollingEvery(Duration.ofSeconds(2));
	wait.withTimeout(Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}**/

//Handling Window
public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
}

public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}

//Handling mouse related operations
public void mouseHoverOp(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}

public void mouseRightClickElementOp(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}

public void mouseRightClickOp(WebDriver driver) {
	Actions act=new Actions(driver);
	act.contextClick().perform();
}

public void mouseDoubleClickElementOp(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}

public void mouseDoubleClickOp(WebDriver driver) {
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}

public void mouseDragAndDrop(WebDriver driver,WebElement element1, WebElement element2) {
	Actions act=new Actions(driver);
	act.dragAndDrop(element1, element2);
}

public void mouseScrollToElementOp(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.scrollToElement(element).perform();
}

public void mouseMoveToElementOp(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}

//Handling using  JavascriptExecutor
public void scrollToElement(WebDriver driver,WebElement element) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("argument[0].scrollIntoView(true);", element);
	
}
public void scrollToWholeDocument(WebDriver driver) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
}

public void scrollToParticularLength(WebDriver driver,int size) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,"+size+")", "");
}

//Handling Screenshot
public String takeScreenshot(WebDriver driver,String screenShotName) throws IOException {
	JavaUtility jLib=new JavaUtility();
	//String sysdate=new Date().toString().replace(" ","_").replace(":","_");
	TakesScreenshot ts=(TakesScreenshot) driver;
	String path=ts.getScreenshotAs(OutputType.BASE64);
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./Screenshots/"+jLib.getSysDate()+".png");
	FileUtils.copyFile(src,dst);
	return path;
}

//Handling Alert
public void switchingAlertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}

public void switchingAlertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}

public String getAlertText(WebDriver driver) {
	String alertText=driver.switchTo().alert().getText();
	return alertText;
}

//Handling Frames //method overloading
public void switchingFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
public void switchingFrame(WebDriver driver,String nameID) {
	driver.switchTo().frame(nameID);
}
public void switchingFrame(WebDriver driver,WebElement frameElement) {
	driver.switchTo().frame(frameElement);
}
public void switchingToParentFrame(WebDriver driver) {
	driver.switchTo().parentFrame();
}

//Handling Select class //method overloading
public void select(WebElement element,String text) {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}

public void select(WebElement element,int index) {
	Select sel=new Select(element);
	sel.selectByIndex(index);
}

public void selectByValue(WebElement element,String value) {
	Select sel=new Select(element);
	sel.selectByValue(value);;}
//Handling multiple windows
public void SwitchingTabsUsingURL(WebDriver driver,String partialURL) {
	Set<String> winIds=driver.getWindowHandles();
	Iterator<String> it=winIds.iterator();
	while(it.hasNext()) {
		String winId=it.next();
		driver.switchTo().window(winId);
		
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains(partialURL)){
			break;
		}
		
	}
}

public void SwitchingTabsUsingTitle(WebDriver driver,String partialTitle) {
	Set<String> winIds=driver.getWindowHandles();
	Iterator<String> it=winIds.iterator();
	while(it.hasNext()) {
		String winId=it.next();
		driver.switchTo().window(winId);
		
		String actTitle=driver.getTitle();
		if(actTitle.contains(partialTitle)){
			break;
		}
		
	}
}





}
