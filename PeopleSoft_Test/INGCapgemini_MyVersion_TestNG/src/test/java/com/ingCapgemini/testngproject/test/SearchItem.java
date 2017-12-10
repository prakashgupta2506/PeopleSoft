package com.ingCapgemini.testngproject.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ingCapgemini.testngproject.pagefactory.AddToCart_PO;
import com.ingCapgemini.testngproject.pagefactory.WelcomePage_PO;
import com.ingCapgemini.testngproject.util.CommonUtil;
import com.ingCapgemini.testngproject.util.SeleniumUtil;
import com.ingCapgemini.testngproject.util.Xls_Reader;


public class SearchItem {
	 private static final Logger LOGGER=LogManager.getLogger(LoginToApplication.class);
	 SeleniumUtil seleniumUtil;
	 private Xls_Reader xlread;
	 
	@BeforeMethod
	public void beforeMethod(){
		LOGGER.info("inside before method");
		seleniumUtil= SeleniumUtil.getInstance();
		 xlread=new Xls_Reader();
	}
	
	
	//represents individual test cases
	
	@Test
	public void searchProduct(){
		LOGGER.info("user is logged into the application"+LOGGER.getClass().getCanonicalName());
		int rowNum=xlread.searchTestScenario("SearchItem", "searchProduct");
		String runMode=xlread.getCellData("SearchItem", "RequiredToExecute", rowNum);
		
		CommonUtil.validateRunModes("logintest", "Login", runMode);
		
		int row=xlread.searchTestScenario("Login", "Admin");
		
		String userName=xlread.getCellData("Login", "UserName", row);
		String password=xlread.getCellData("Login", "Password", row);
		
		//u can put login in @BeforeMethod if ur login is common across all the test cases in the class/scenario/module
		
		CommonUtil.login(userName,password);
		
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		
		LOGGER.debug("############  LOGIN SUCCESSFUL for user -   ########################--" +"Admin");
		
		String productName=xlread.getCellData(SearchItem.class.getSimpleName(), "Item", rowNum);
		
         WelcomePage_PO.searchItem(productName);
		
		SeleniumUtil.ValidateWebElementVisible(By.xpath(AddToCart_PO.AddToCart_ProductImage_XPATH.replace("ProductName", productName)));
		CommonUtil.logOut();
		
		
	}
	
	
	
	
	
	
	/*@Test
	public void searchProduct(){
		LOGGER.info("user is logged into the application"+LOGGER.getClass().getCanonicalName());
		int rowNum=xlread.searchTestScenario(SearchItem.class.getSimpleName(), "searchProduct");
		String runMode=xlread.getCellData(SearchItem.class.getSimpleName(), "RequiredToExecute", rowNum);
		if (runMode.equalsIgnoreCase("Y")){
		
		int row=xlread.searchTestScenario("Login", "Admin");
		
		String userName=xlread.getCellData("Login", "UserName", row);
		String password=xlread.getCellData("Login", "Password", row);
		
		//u can put login in @BeforeMethod if ur login is common across all the test cases in the class/scenario/module
		
		CommonUtil.login(userName,password);
		
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		
		LOGGER.debug("############  LOGIN SUCCESSFUL for user -   ########################--" +"Admin");
		
		String productName=xlread.getCellData(SearchItem.class.getSimpleName(), "Item", rowNum);
		
         WelcomePage_PO.searchItem(productName);
		
		SeleniumUtil.ValidateWebElementVisible(By.xpath(AddToCart_PO.AddToCart_ProductImage_XPATH.replace("ProductName", productName)));
		CommonUtil.logOut();
		}
		
	}
	
	*/
	
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
