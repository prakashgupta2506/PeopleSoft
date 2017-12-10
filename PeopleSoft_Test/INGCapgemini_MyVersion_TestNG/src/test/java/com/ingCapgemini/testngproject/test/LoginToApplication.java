package com.ingCapgemini.testngproject.test;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ingCapgemini.testngproject.pagefactory.WelcomePage_PO;
import com.ingCapgemini.testngproject.util.CommonUtil;
import com.ingCapgemini.testngproject.util.SeleniumUtil;
import com.ingCapgemini.testngproject.util.Xls_Reader;


public class LoginToApplication {
	 private static final Logger LOGGER=LogManager.getLogger(LoginToApplication.class);
	 SeleniumUtil seleniumUtil;
	 private Xls_Reader xlread;
	 
	@BeforeMethod
	public void beforeMonth(){
		LOGGER.info("inside before method");
		seleniumUtil= SeleniumUtil.getInstance();
		 xlread=new Xls_Reader();
	}
	
	@Test
	public void logintest() throws IOException{
		
		LOGGER.info("user is logged into the application"+LOGGER.getClass().getCanonicalName());
		int row=xlread.searchTestScenario("Login", "Admin");
		LOGGER.info("read excel");
		String userName=xlread.getCellData("Login", "UserName", row);
		String password=xlread.getCellData("Login", "Password", row);
		CommonUtil.login(userName,password);
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		LOGGER.debug("############  LOGIN SUCCESSFUL for user -   ########################--" +"Admin");
		CommonUtil.logOut();
		SeleniumUtil.takeScreenShot();
		
	}
	
	
	@AfterMethod
	public void afterMethod(){
		if (SeleniumUtil.driverStatus==true){
		System.out.println("######################  i am inside kill browser ############################");
	SeleniumUtil.closeBrowser();
	SeleniumUtil.setDriver(null);
	seleniumUtil=null;
	}
	}

}
