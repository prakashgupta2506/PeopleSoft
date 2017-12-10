package com.ingcapgemini.wm.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ingcapgemini.wm.pageobjectmodel.HomePage;
import com.ingcapgemini.wm.pageobjectmodel.Login;

public class CommonUtil {
public static WebConnector webConnector=WebConnector.getInstance();
private static final Logger LOGGER=LogManager.getLogger(CommonUtil.class);
public static void login(String userId){
	LOGGER.info("############  INSIDE LOGIN ########################");
	WebDriver driver=webConnector.getDriver();//browser has been open
	
	driver.manage().window().maximize();
	SeleniumUtil.ImplicitWait(driver);
	driver.get(WebConnector.getConfigProperties().getProperty(System.getProperty("ENV")+"_App_URL"));
	Assert.assertEquals("the page title is not matching",Login.LOGIN_PAGE_TITLE ,SeleniumUtil.getTitle(driver));
	Login.loginToApp(driver, WebConnector.getConfigProperties().getProperty(userId), WebConnector.getConfigProperties().getProperty(userId+"_password"));
	
	SeleniumUtil.ValidateWebElementPresence(driver,By.id(HomePage.HOME_PAGE_WELCOME_ID));
	LOGGER.debug("############  LOGIN SUCCESSFUl ########################");
	
}




}

