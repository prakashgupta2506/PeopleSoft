package com.ingcapgemini.wm.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ingcapgemini.wm.common.GlobalStepDefinition;
import com.ingcapgemini.wm.pageobjectmodel.CreateAccountPage_PO;
import com.ingcapgemini.wm.pageobjectmodel.HomePage_PO;
import com.ingcapgemini.wm.pageobjectmodel.Login_PO;
import com.ingcapgemini.wm.pageobjectmodel.WelcomePage_PO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class CommonUtil { 
	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtil.class);
		
  static WebDriver driver;
  //private static String email;
		
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
		
		//driver=SeleniumUtil.getInstance().getDriver();//if u need  to it..
		
		//SeleniumUtil.maximizeBrowser();
		
		//SeleniumUtil.ImplicitWait();	
		
		CommonUtil.launchApplication();
		// OR SeleniumUtil.getInstance().getDriver().get(SeleniumUtil.getConfigProperties().getProperty(System.getProperty("ENV") + "_App_URL"));
		 //OR driver.get(SeleniumUtil.getConfigProperties().getProperty(System.getProperty("ENV") + "_App_URL"));
		
		
		//Assert.assertTrue(false);
		
		HomePage_PO.clickSignIn_HomePage();
		
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(Login_PO.LOGIN_PAGE_EMAIL_CSS));
		
		Login_PO.loginToApplication(userId, password);		
		
		
	}

	
	public static void launchApplication(){
		
		driver=SeleniumUtil.getInstance().getDriver();
		
		SeleniumUtil.maximizeBrowser();
		
		SeleniumUtil.ImplicitWait();
		
		driver.get(SeleniumUtil.getConfigProperties().getProperty(System.getProperty("ENV") + "_App_URL"));
		
		Assert.assertEquals("the page title is not matching", HomePage_PO.HOME_PAGE_TITLE, SeleniumUtil.getTitle());		
		SeleniumUtil.ValidateWebElementPresence(By.className(HomePage_PO.HOME_PAGE_SIGNIN_CLASSNAME));
		
		
	}

	
	
/*public static void NavigateToCreateAccountPageAfterEnteringEmail(String sheetName,int rowNum){
	
		LOGGER.info("########## Inside NavigateToCreateAccountPage  ##########");
		Xls_Reader xlread = GlobalStepDefinition.xlread;		

		CommonUtil.launchApplication();
		//avoid using _
		HomePage_PO.clickSignIn_HomePage();

		email = xlread.getCellData(sheetName, "Email", rowNum);
		
		GlobalStepDefinition.setEmail(email);
		
		SeleniumUtil.setValue(By.id(Login_PO.LOGIN_PAGE_EMAIL_FORCREATEACCOUNT_ID), email);
		SeleniumUtil.clickWebElement(By.id(Login_PO.LOGIN_PAGE_CREATEACCOUNTBUTTON_ID));
		SeleniumUtil.ValidateWebElementVisible(By.id(CreateAccountPage_PO.FIRSTNAME_ID));
		//return email;
	}*/

}
