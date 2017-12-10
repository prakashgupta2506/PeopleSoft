package com.ingcapgemini.wm.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ingcapgemini.wm.pageobjectmodel.WelcomePage_PO;
//import com.ingcapgemini.wm.story.leave.ApplyLeave;
import com.ingcapgemini.wm.util.CommonUtil;
//import com.ingcapgemini.wm.util.SeleniumUtil;
import com.ingcapgemini.wm.util.SeleniumUtil;
import com.ingcapgemini.wm.util.Xls_Reader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.formatter.model.Feature;

public class GlobalStepDefinition {

	SeleniumUtil seleniumUtil;

	private static final Logger LOGGER = LogManager.getLogger(GlobalStepDefinition.class);
	public static int rowNum;
	public static String sheetName;
	public static Xls_Reader xlread;
	public static String scenarioName;
	public static String runMode;//for execution on basis of y/n in excel..
	public static Scenario scenario;//used for reporting
	
	private static String email;//since email is created in commonutil and used in other class UserRegistration.used for geter and setter
	

	@Before(order = 0)
	public void Setup(Scenario scenario) {

		GlobalStepDefinition.scenario=scenario;
		seleniumUtil = SeleniumUtil.getInstance();
		System.out.println("before setup");
		/*
		 * String scenarioName = scenario.getName(); System.out.println(
		 * "print scenario name " + scenarioName);
		 * 
		 * Collection<String> col = scenario.getSourceTagNames(); // Iterator
		 * it= col.iterator(); for (String tagname : col) {
		 * 
		 * System.out.println("print tagname " + tagname);
		 * 
		 * }
		 */
		String arr[]=scenario.getId().split(";");
		
		sheetName = scenario.getId().split(";")[0];
		scenarioName = scenario.getId().split(";")[1];

		xlread = new Xls_Reader();
		rowNum = xlread.searchTestScenario(sheetName, scenarioName);
		runMode=xlread.getCellData(sheetName, "RunMode", rowNum);////for execution on basis of y/n in excel..
		// System.out.println("print the row number "+rowNum);

	}

	@Given("^user \"(.*?)\" login into the application with correct credentials DataTable$")
	public void user_with_password_login_into_the_application_DataTable(String arg1) {
		LOGGER.info("########## Inside user_with_password_login_into_the_application_DataTable, argument--" + arg1 + " ##########");
		// Write code here that turns the phrase above into concrete actions
		// good to have...gets fulls path of the class
		LOGGER.info("Inside user_with_password_login_into_the_application_DataTable" + LOGGER.getClass().getCanonicalName());
		int row = xlread.searchTestScenario("Login", arg1);
		String userName = xlread.getCellData("Login", "UserName", row);
		String password = xlread.getCellData("Login", "Password", row);
		CommonUtil.login(userName, password);
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		LOGGER.debug("############  LOGIN SUCCESSFUL for user -   ########################--" + arg1);
		
        
		
		
		
	}

	@Given("^User \"(.*?)\" with password \"(.*?)\" login into the application with correct credentials$")
	public void user_with_password_login_into_the_application(String arg1, String arg2) {
		// Write code here that turns the phrase above into concrete actions
		// good to have...gets fulls path of the class
		LOGGER.info("user " + arg1 + " is logged into the application" + LOGGER.getClass().getCanonicalName());

		CommonUtil.login(arg1, arg2);
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		LOGGER.debug("############  LOGIN SUCCESSFUL for user -   ########################--" + arg1);

	}

	@When("^User successfully log out of the application after clicking on log out button$")
	public void user_successfully_log_out_of_the_application_after_clicking_on_log_out_button() {
		
		CommonUtil.logOut();

	}


	@Given("^Just Run$")
	public void just_Run() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("I have run !!!");
	    
	}
	
	
		
	@After(order = 0)
	public void TearDown(Scenario scenario) throws IOException {
		LOGGER.info("########## Tear Down ##########");	
		if (SeleniumUtil.driverStatus == true) {
			if (scenario.isFailed()) {
				LOGGER.info("########## i am inside screen shot after fail ##########");	
				final byte[] screenshot = ((TakesScreenshot) seleniumUtil.getDriver()).getScreenshotAs(OutputType.BYTES);				
				scenario.embed(screenshot, "image/png"); // stick it in the report
				SeleniumUtil.takeScreenShot(scenario.getId());//forecfully takescreenshot..
						
						
										
				
												
							
				
			}
		}

		// set driver object to null
		/*if (SeleniumUtil.driverStatus == true) {
			LOGGER.info("########## Inside Kill Browser ##########");
			SeleniumUtil.closeBrowser();
			SeleniumUtil.setDriver(null);
		}*/

		
		 
	 
		
		
	}
	
	public static String getEmail() {
		return email;

	}

	public static void setEmail(String value) {
		email = value;
	}

	
	
	
	
}
