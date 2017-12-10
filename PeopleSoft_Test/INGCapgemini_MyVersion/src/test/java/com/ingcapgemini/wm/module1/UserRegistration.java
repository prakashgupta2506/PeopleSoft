package com.ingcapgemini.wm.module1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.ingcapgemini.wm.common.GlobalStepDefinition;
import com.ingcapgemini.wm.pageobjectmodel.CreateAccountPage_PO;
import com.ingcapgemini.wm.pageobjectmodel.HomePage_PO;
import com.ingcapgemini.wm.pageobjectmodel.Login_PO;
import com.ingcapgemini.wm.pageobjectmodel.WelcomePage_PO;
import com.ingcapgemini.wm.util.CommonUtil;
import com.ingcapgemini.wm.util.SeleniumUtil;
import com.ingcapgemini.wm.util.Xls_Reader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistration {
	
	private static final Logger LOGGER = LogManager.getLogger(UserRegistration.class);
	
	
	Xls_Reader xlread = GlobalStepDefinition.xlread;
	
	private static String email;//this one is used onyl for the fn "user ab navigates to create account page with datarow as"
	
	//problem when this way is even a called method does not use the row and sheetname,these get uselessly initialized.hence u can declare them locally
	/*String sheetName = GlobalStepDefinition.sheetName;
	private int rowNum = GlobalStepDefinition.rowNum;*/
	
		
		
	@When("^user ab navigates to create account page with datarow as (\\d+)$")
	public void user_navigates_to_create_account_page(int dataRow) throws Throwable {
		
		LOGGER.info("########## Inside user_navigates_to_create_account_page  ##########");
		String sheetName=GlobalStepDefinition.sheetName;
		int rowNum=GlobalStepDefinition.rowNum;
		int rowNumForData;
		CommonUtil.launchApplication();
		HomePage_PO.clickSignIn_HomePage();
		if (dataRow == 0)
			rowNumForData=rowNum;
			else
			rowNumForData = dataRow;
		String email = xlread.getCellData(sheetName, "Email", rowNumForData);
		SeleniumUtil.setValue(By.id(Login_PO.LOGIN_PAGE_EMAIL_FORCREATEACCOUNT_ID), email);
		SeleniumUtil.clickWebElement(By.id(Login_PO.LOGIN_PAGE_CREATEACCOUNTBUTTON_ID));
		SeleniumUtil.ValidateWebElementVisible(By.id(CreateAccountPage_PO.FIRSTNAME_ID));
	   
	}

		
	@When("^user navigates to create account page")
	public void user_navigates_to_create_account_page() throws Throwable {
	
		LOGGER.info("########## Inside user_navigates_to_create_account_page  ##########");	
		String sheetName=GlobalStepDefinition.sheetName;
		int rowNum=GlobalStepDefinition.rowNum;
		
		NavigateToCreateAccountPageAfterEnteringEmail(sheetName, rowNum);
		
	   
	}
	
	
	

	@And("^enters all the required details and register$")
	public void he_enters_all_the_required_details_and_register() throws Throwable {
		LOGGER.info("########## Inside he_enters_all_the_required_details_and_register  ##########");
		String sheetName=GlobalStepDefinition.sheetName;
		int rowNum=GlobalStepDefinition.rowNum;
		CreateAccountPage_PO.inputRegistrationDetails(sheetName,rowNum);
	   
				
	}

	@Then("^new user should be created and should be able to login successfully$")
	public void new_user_should_be_created_and_should_be_able_to_login_successfully() throws Throwable {
		LOGGER.info("########## Inside new_user_should_be_created_and_should_be_able_to_login_successfully  ##########");
		SeleniumUtil.ValidateWebElementVisible(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		
		
		//this is to showcase keeping values at common place and retreiving via setter and getter...otherwise u could have simply declared email at class level and use it across all the methods here...
		LOGGER.debug("############  New user created successfully. Email id of new user-"+GlobalStepDefinition.getEmail()+". Name-"+CreateAccountPage_PO.FirstName);
		
		GlobalStepDefinition.scenario.write("############  New user created successfully. Email id of new user-"+GlobalStepDefinition.getEmail()+". Name-"+CreateAccountPage_PO.FirstName);
		
		CommonUtil.logOut();
					
		CommonUtil.login(GlobalStepDefinition.getEmail(), CreateAccountPage_PO.Password);
		
		
		String expectedUserName=CreateAccountPage_PO.FirstName+" "+CreateAccountPage_PO.LastName;
		String createdUserName=SeleniumUtil.getWebElementText(By.xpath(WelcomePage_PO.CREATEDUSERNAME_XPATH));
		Assert.assertEquals("Name does not match", expectedUserName, createdUserName);
		
					
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));
		
		
		
	}

	
	@When("^User registration for multiple users with data from rows (\\d+) to (\\d+)$")
	public void user_registration_for_multiple_users_with_data_from_rows_to(int startRow, int endRow) throws Throwable {

		for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
			
			String sheetName=GlobalStepDefinition.sheetName;
			
			//user_navigates_to_create_account_page(rowNum);//for calling the step definition  instead of separate common function
			
			NavigateToCreateAccountPageAfterEnteringEmail(sheetName, rowNum);			

			CreateAccountPage_PO.inputRegistrationDetails(sheetName, rowNum);
			
			SeleniumUtil.ValidateWebElementVisible(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));			
				
			new_user_should_be_created_and_should_be_able_to_login_successfully();
			
			CommonUtil.logOut();
			
			
			
		}

	}
	
	
	@When("^User registration for multiple users with data from rows \"(.*?)\"$")
	public void user_registration_for_multiple_users_with_data_from_rows(String strRowNum) throws Throwable {
		String sheetName=GlobalStepDefinition.sheetName;
				
		
		int rowNum1=Integer.parseInt(strRowNum);
		
		NavigateToCreateAccountPageAfterEnteringEmail(sheetName, rowNum1);			

		CreateAccountPage_PO.inputRegistrationDetails(sheetName, rowNum1);
		
		SeleniumUtil.ValidateWebElementVisible(By.cssSelector(WelcomePage_PO.WELCOMEPAGE_SIGNOUT_CSS));			
			
		new_user_should_be_created_and_should_be_able_to_login_successfully();
		
		CommonUtil.logOut();
	 
	}
	
	
	private static void NavigateToCreateAccountPageAfterEnteringEmail(String sheetName,int rowNum){
		
		LOGGER.info("########## Inside NavigateToCreateAccountPage  ##########");
		Xls_Reader xlread = GlobalStepDefinition.xlread;		

		CommonUtil.launchApplication();
		//avoid using _
		HomePage_PO.clickSignIn_HomePage();

		email = xlread.getCellData(sheetName, "Email", rowNum);
		
		//this is to showcase keeping values at common place and retreiving via setter and getter...
		GlobalStepDefinition.setEmail(email);
		GlobalStepDefinition.scenario.write("########### Creating account for "+GlobalStepDefinition.getEmail());
		SeleniumUtil.setValue(By.id(Login_PO.LOGIN_PAGE_EMAIL_FORCREATEACCOUNT_ID), email);
		SeleniumUtil.clickWebElement(By.id(Login_PO.LOGIN_PAGE_CREATEACCOUNTBUTTON_ID));
		SeleniumUtil.ValidateWebElementVisible(By.id(CreateAccountPage_PO.FIRSTNAME_ID));
		//return email;
	}

	//for execution on basis of y/n in excel..
	@When("^User launches the application$")
	public void user_launches_the_application() throws Throwable {
		
	
		//this way or declare variable requiredToExecute as below...
		if (GlobalStepDefinition.runMode.equalsIgnoreCase("Y")) {
			CommonUtil.launchApplication();
			GlobalStepDefinition.scenario.write("Application launch successful");
		}
	}
//for execution on basis of y/n in excel..
	@Then("^Welcome page should be displayed$")
	public void welcome_page_should_be_displayed() throws Throwable {
		String requiredToExecute=GlobalStepDefinition.runMode;//for execution on basis of y/n in excel..
		if (requiredToExecute.equalsIgnoreCase("Y")) {
			Assert.assertEquals("the page title is not matching", HomePage_PO.HOME_PAGE_TITLE, SeleniumUtil.getTitle());
			GlobalStepDefinition.scenario.write("Welcome Page displayed successfully");
		}
	}
	
	
	
	

}
