package com.auto.cloud.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.auto.cloud.utilities.Helper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public final class LoginApplicationPage extends BaseClass {

	WebDriver driver;

	public LoginApplicationPage(WebDriver wdriver) {
		this.driver = wdriver;
	}

	@FindBy(how = How.ID, using = "userid")
	private WebElement userName;

	@FindBy(how = How.ID, using = "password")
	private WebElement passWord;

	@FindBy(how = How.ID, using = "btnActive")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "//a[@id='forgotLink']")
	private WebElement forgotPass;

	@FindBy(how = How.XPATH, using = "//*[name()='path' and contains(@class,'svg-icon03')]")
	private WebElement navigatorLnk;

	@FindBy(how = How.ID, using = "pt1:nv_itemNode_manager_resources_manage_users")
	private WebElement node;

	@FindBy(how = How.XPATH, using = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_manage_users:0:_FOTsr1:0:AP1:qq1:criterionValue0::content']")
	private WebElement searchKey;

	@FindBy(how = How.XPATH, using = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_manage_users:0:_FOTsr1:0:AP1:qq1::search_icon']")
	private WebElement searchIcon;

	@FindBy(how = How.XPATH, using = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_manage_users:0:_FOTsr1:0:AP1:gallerySearchVOCriteriaQueryResultId:_ATp:table1:0:ot3']")
	private WebElement queryRes;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'ave and Close')]")
	private WebElement save;

	public void login_OracleApp(String uid, String pwd) throws IOException {

		userName.sendKeys(uid);
		passWord.sendKeys(pwd);
		signIn.click();

	}

	/**
	 * @throws IOException
	 **/

	public void oracleCloudUsersRole() throws IOException {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(navigatorLnk));
		navigatorLnk.click();
		Reporter.log("Navigator clicked");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		node.click();
		Reporter.log("Clicked on Link - Users And Roles");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait waitr = new WebDriverWait(driver, 30);
		waitr.until(ExpectedConditions.visibilityOf(searchKey));
		System.out.println("Input Key search box present");
		searchKey.click();
		System.out.println("SearchBox is editable");
		searchKey.sendKeys("Veena");
		searchIcon.click();
		System.out.println("Clicked on Search Icon");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		queryRes.click();
		Reporter.log("Verify fetched User details");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		save.click();
		Reporter.log("Clicked on Save button");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("OracleCloudUsersRoleTest Passed");

	}
}
