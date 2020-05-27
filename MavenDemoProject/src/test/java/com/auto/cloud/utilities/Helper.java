package com.auto.cloud.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/OracleCloud_"+getCurrentDateTime()+".png";
		try {
			
			FileHandler.copy(src, new File(path));
			
		} catch (IOException e) {
			System.out.println("Unable to take screenshot"+ e.getMessage());
		}
		
		return path;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customformat = new SimpleDateFormat("MM_DD_YYYY_HH_MM_SS");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}

}
