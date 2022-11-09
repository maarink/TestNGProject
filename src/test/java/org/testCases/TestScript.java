package org.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScript {
	WebDriver driver;
	ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;

	@BeforeSuite
	public void launchBrowser() {
		extentReport = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extentReport.attachReporter(htmlReporter);

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Axyya\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test1() throws IOException {
		driver.get("https://www.flipkart.com/");
	//	testCase.log(Status.INFO, "Navigating to flipkart");
		testCase = extentReport.createTest("Verify flipkart");
		testCase.log(Status.PASS, "Actual title and Expected title");
		TakesScreenshot tk = (TakesScreenshot) driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		File to = new File("sample.png");
		FileUtils.copyFile(from, to);
		testCase.addScreenCaptureFromPath("sample.png");
	}

	@Test
	public void test2() {
		testCase.log(Status.INFO, "Navigating to facebook");
		driver.get("https://www.facebook.com/");
		testCase = extentReport.createTest("Verify facebook");
		testCase.log(Status.PASS, "Actual title and Expected title");
	}

	@Test
	public void test3() {
		testCase.log(Status.INFO, "Navigating to amazon");
		driver.get("https://www.amazon.in/");
		testCase = extentReport.createTest("Verify amazon");
		testCase.log(Status.PASS, "Actual title and Expected title");
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		extentReport.flush();
		// driver.f
		System.out.println("successfully");
	}

}
