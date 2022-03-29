package com.crm.autodesk.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this class is used to implement the ITestListener interface
 * @author CHANNAKESHVA REDDY
 *
 */
public class ListenerImplementionClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		//step 4:log success method 
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
	}

	public void onTestFailure(ITestResult result) {
		//step 6:log fail method,take screenshot ,attach screenshot to extent report
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName);
		test.log(Status.FAIL, result.getThrowable());
		String path=null;
		WebDriverUtility wu=new WebDriverUtility();
		try {
			path=wu.takeScreenShot(BaseClass.sDriver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		///step 5:log skipped method
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName);
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//step 1:Extent report configuration
		String methodName = context.getName();
		ExtentSparkReporter extent = new ExtentSparkReporter("./ExtentReports/ExtentReporter.html"+new JavaUtility().getSystemTime());
		extent.config().setReportName("Smoke Testing");
		extent.config().setDocumentTitle("com.crm.autodesk.seleniumframework");
		extent.config().setTheme(Theme.DARK);
		
		//step 2:Attach the physical report and do the system configuration
		report=new ExtentReports();
		report.attachReporter(extent);
		report.setSystemInfo("os", "Windows 10");
		report.setSystemInfo("Environment", "Testing");
		report.setSystemInfo("Url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Keshava");
		
	}

	public void onFinish(ITestContext context) {
		String name = context.getName();
		report.flush();
	}
	
	

}
