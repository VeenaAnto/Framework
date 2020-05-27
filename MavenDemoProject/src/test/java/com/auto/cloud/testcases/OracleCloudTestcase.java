package com.auto.cloud.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.cloud.pages.BaseClass;
import com.auto.cloud.pages.LoginApplicationPage;
import com.auto.cloud.utilities.BrowserFactory;
import com.auto.cloud.utilities.ExcelDataProvider;
import com.auto.cloud.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OracleCloudTestcase extends BaseClass {

	@Test
	public void loginApplication() throws IOException {

		logger = report.createTest("loginApplication");
		logger.info("Login to application");
		Reporter.log("Application Login initiated", true);
		LoginApplicationPage loginP = PageFactory.initElements(driver, LoginApplicationPage.class);
		loginP.login_OracleApp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Application logged in Successfully", true);
		System.out.println("Title: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Welcome"));

	}

}
