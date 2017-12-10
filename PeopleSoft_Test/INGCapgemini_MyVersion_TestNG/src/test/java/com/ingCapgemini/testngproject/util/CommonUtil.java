package com.ingCapgemini.testngproject.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import com.ingCapgemini.testngproject.pagefactory.HomePage_PO;
import com.ingCapgemini.testngproject.pagefactory.Login_PO;
import com.ingCapgemini.testngproject.pagefactory.Login_PO_PF;
import com.ingCapgemini.testngproject.pagefactory.WelcomePage_PO;


public class CommonUtil { 
	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtil.class);
		
    static WebDriver driver;
	
		
	public static void validateRunModes(String testName,String suiteName,String dataRunMode){
		
		if(!(dataRunMode.equalsIgnoreCase("Y")||dataRunMode.equalsIgnoreCase("YES"))){
			throw new SkipException("Skipping the test"+testName+" inside suite "+suiteName);
		}
	}

	
	public static void logOut(){
		
		LOGGER.info("############  INSIDE LOGOUT  ########################");
		//sign out could be different in diff pages...u can driver.findelement(by)....and pass the locator to this sign out method
		WelcomePage_PO.clickSignOut();
		SeleniumUtil.ValidateWebElementPresence(By.className(HomePage_PO.HOME_PAGE_SIGNIN_CLASSNAME));
			
		//Assert.assertTrue("LogOut Successful", true);
		LOGGER.debug("############  LOGOUT SUCCESSFUL  ########################");
		
				
		
	}

	public  static void login(String userId, String password) {		
		
		LOGGER.info("############  INSIDE LOGIN ########################");
		
		driver=SeleniumUtil.getInstance().getDriver();//if u need  to it..
		
		SeleniumUtil.maximizeBrowser();
		
		SeleniumUtil.ImplicitWait();		
		
		SeleniumUtil.launchApplication();
		// OR SeleniumUtil.getInstance().getDriver().get(SeleniumUtil.getConfigProperties().getProperty(System.getProperty("ENV") + "_App_URL"));
		 //OR driver.get(SeleniumUtil.getConfigProperties().getProperty(System.getProperty("ENV") + "_App_URL"));
		
		Assert.assertEquals("the page title is not matching", HomePage_PO.HOME_PAGE_TITLE, SeleniumUtil.getTitle());		
		SeleniumUtil.ValidateWebElementPresence(By.className(HomePage_PO.HOME_PAGE_SIGNIN_CLASSNAME));
		Assert.assertEquals("the page title is not matching", HomePage_PO.HOME_PAGE_TITLE, SeleniumUtil.getTitle());
		HomePage_PO.clickSignIn_HomePage();
		
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(Login_PO.LOGIN_PAGE_EMAIL_CSS));
		
		
		
	/*	//used for page factory
		Login_PO_PF loginpf=new Login_PO_PF(driver); 
		loginpf.loginToApplication(userId, password);*/
		Login_PO.loginToApplication(userId, password);		
		
		
	}

	
	



}
