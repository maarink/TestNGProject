package org.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testscript1 {
	WebDriver driver;
	ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;

	
@BeforeSuite
public void launch() {
	extentReport = new ExtentReports();
	htmlReporter = new ExtentHtmlReporter("ExtentReport1.html");
	extentReport.attachReporter(htmlReporter);
}
	
@Test(groups="smoke")
public void test1() {
	testCase = extentReport.createTest("Verify test1");
	System.out.println("----test1-------");
}
	
@Test(groups="sanity")
public void test2() {
	System.out.println("----test2-------");
}
	
@Test(groups="regression")
public void test3() {
	testCase = extentReport.createTest("Verify test3");
	System.out.println("----test3-------");
}	
	
@Test(groups="rerun")
public void test4() {
	System.out.println("----test4-------");
}	
@Test(groups="smoke")
public void test5() {
	testCase = extentReport.createTest("Verify test5");
	System.out.println("----test5-------");
}	
	
@AfterSuite
public void closeBrowser() {
//	driver.quit();
	extentReport.flush();
	// driver.f
	System.out.println("successfully");
}
	
	
}
