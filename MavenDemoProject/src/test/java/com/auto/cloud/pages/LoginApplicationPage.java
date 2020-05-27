package com.auto.cloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public final class LoginApplicationPage {
	
	WebDriver driver;
	
	public  LoginApplicationPage(WebDriver wdriver) {
		this.driver =  wdriver;
	}
	
	@FindBy(how = How.ID, using = "userid")
	private WebElement userName;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement passWord;
	
	@FindBy(how =  How.ID, using = "btnActive")
	private WebElement signIn;
	
	@FindBy(how = How.XPATH, using = "//a[@id='forgotLink']")
	private WebElement forgotPass;
	
	public void login_OracleApp(String uid, String pwd) {
		userName.sendKeys(uid);
		passWord.sendKeys(pwd);
		signIn.click();
		
		
	}
	

}
