package com.ninja.crm.listenersutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ninja.crm.generic.webdriverutility.BaseClass;

public class ListenersPractice implements ITestListener,ISuiteListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Date d = new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./LowLevelReport/"+date+"VtigerReport.html");
		spark.config().setDocumentTitle("AdvancedReports");
		spark.config().setReportName("VtigerReport");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Laptop", "Lenovo");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		//Reporter.log(testCase+" Execution Started");
		test = report.createTest(testCase);
		test.log(Status.INFO, testCase+" Execution Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		//Reporter.log(testCase+" Execution Passed");
		test.log(Status.PASS, testCase+" Execution Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		//Reporter.log(testCase+" Execution Failed");
		test.log(Status.FAIL, testCase+" Execution Failed");
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		Reporter.log(testCase+" Execution Skipped");
		test.log(Status.SKIP, testCase+" Execution Skipped");
		
	}

	
}
