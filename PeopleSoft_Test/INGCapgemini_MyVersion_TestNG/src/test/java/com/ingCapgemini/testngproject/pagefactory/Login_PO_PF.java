package com.ingCapgemini.testngproject.pagefactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ingCapgemini.testngproject.util.SeleniumUtil;



public class Login_PO_PF {
	
	private static final Logger LOGGER=LogManager.getLogger(Login_PO_PF.class);
	
	
	public static final String LOGIN_PAGE_EMAIL_CSS="input#email";
	@FindBy(css=LOGIN_PAGE_EMAIL_CSS)
	private WebElement loginUser;
	
	public static final String LOGIN_PAGE_PASSWORD_CSS="input[id=passwd]";
	@FindBy(css=LOGIN_PAGE_PASSWORD_CSS)
	private WebElement loginPassword;
	
	public static final String LOGIN_PAGE_SIGNIN_BUTTON_ID="SubmitLogin";
	@FindBy(id=LOGIN_PAGE_SIGNIN_BUTTON_ID)
	private WebElement signButton;
	
	 public	Login_PO_PF(WebDriver driver){
			
			PageFactory.initElements(driver, this);
			
		}
	
	public  void loginToApplication(String userName, String password){
		LOGGER.info("############# inside Login_PO method ###################");
		if (userName!=null){
			
			
			loginUser.sendKeys(userName);
			
		}
		if (password!=null){
			//SeleniumUtil.setValue(By.cssSelector(LOGIN_PAGE_PASSWORD_CSS), password);			
			loginPassword.sendKeys(password);
		}
		//SeleniumUtil.clickWebElement(By.id(LOGIN_PAGE_SIGNIN_BUTTON_ID));
		signButton.click();
		SeleniumUtil.wait(2000);
	}
	
	
}
