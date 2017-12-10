package com.cucumberJunit.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtil {
	
	private static final Logger logger=Logger.getLogger(SeleniumUtil.class);
	private static String ScreenShotFolder=System.getProperty("user.dir")+"//ScreenShot";
	
	public static WebElement getWebElement(WebDriver driver,By by){
		logger.debug("inside getWebElement");
		WebElement webElement=driver.findElement(by);
		return webElement;
	}

	public static void takeScreenShot(WebDriver driver) throws IOException{
		Date date=new Date();
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-sss");  
	    String strDate= (new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-sss")).format(date);  
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("ScreenShotFolder//ScreenShot"+strDate));
	}
	
	public static String getSimpleDateFormate(Date date,String formate){
		 
	    SimpleDateFormat formatter = new SimpleDateFormat(formate);  
	    String strDate= formatter.format(date);  
	    return strDate;
	}
	
	
	public static boolean checkPageTitle(WebDriver driver,String title){
		if (title.equalsIgnoreCase(driver.getTitle())){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public static String getTextMessage(WebDriver driver,By by){
		
		return driver.findElement(by).getText();
		
		
	}
}
