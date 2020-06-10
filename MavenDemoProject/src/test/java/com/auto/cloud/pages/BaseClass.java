package com.auto.cloud.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.auto.cloud.utilities.BrowserFactory;
import com.auto.cloud.utilities.ConfigDataProvider;
import com.auto.cloud.utilities.ExcelDataProvider;
import com.auto.cloud.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() throws IOException {
		Reporter.log("Setting up reports and Test getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		/**ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/Reports/OracleCloudExtentReport" + Helper.getCurrentDateTime() + ".html");*/
				ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")
						+ "/Reports/OracleCloudExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
		Reporter.log("Setting done successfully - Test can be started", true);
	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser instance for opening application", true);
		driver = BrowserFactory.startBrowser(driver, config.getBrowserData(), config.getURLData());
		Reporter.log("Browser instance started successfully and opened application", true);

	}

	@AfterClass
	public void closeBrowser() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Extent Report initiated for reporting results", true);

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test passsed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();
		Reporter.log("Test completed successfully >>>>> Reports generated", true);

	}

}
