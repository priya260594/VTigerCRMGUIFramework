package com.VTiger.crm.ListenerUtility;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.VTiger.crm.BaseClass.BaseClass;
import com.VTiger.crm.generic.javautility.JavaUtility;
import com.VTiger.crm.generic.webdriverutility.UtilityClassObject;
import com.VTiger.crm.generic.webdriverutility.WebDriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener, ISuiteListener { //multiple inheritance concept

	ExtentReports report;
	public static ExtentTest test;
	JavaUtility jLib=new JavaUtility();
	
	public void onTestStart(ITestResult result) {
		//Reporter.log(result.getMethod().getMethodName()+" is started",true);
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+" is started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriverUtility wLib=new WebDriverUtility();
        String testName=result.getMethod().getMethodName();
        
        String destpath;
		try {
			destpath = wLib.takeScreenshot(BaseClass.sdriver, testName);
			test.addScreenCaptureFromBase64String(destpath,testName+"_"+jLib.getSysDate()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, testName+" is failed");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+jLib.getSysDate()+".html");
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM results");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "Chrome-129");
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

	/** public void onStart(ISuite suite) {
		System.out.println("Report configuration");
	}
	public void onFinish(ISuite suite) {
		System.out.println("Report backup"); 
	}**/
	

}
