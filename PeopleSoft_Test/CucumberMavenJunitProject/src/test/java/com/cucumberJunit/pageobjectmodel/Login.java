package com.cucumberJunit.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumberJunit.util.SeleniumUtil;

import junit.framework.Assert;

public class Login {
	
	public static final String SIGNINTITLE="Gmail - Free Storage and Email from Google";
	public static final String SIGNIN_XPATH="//a[contains(text(),'Sign In')]";
	public static final String LOGINTITLE="Gmail";
	public static final String EMAIL_ID="Email";
	public static final String PASSWORD_ID="Passwd";
	public static final String SIGNINBUTTON_ID="signIn";
	public static final String ERRORMESSAGE_ID="Error";
	public static final  String SUBMENU_XPATH_INDEX="(//a[contains(@inner,'text')])[index]";
	public static final  String SUBMENU_XPATH="//a[contains(@inner,'text')]";
		
	public static void clickSubmenu(WebDriver driver,String innerText){
		String xpath=SUBMENU_XPATH.replace("text", innerText);		
	  	SeleniumUtil.getWebElement(driver, By.xpath(SUBMENU_XPATH.replace("text", innerText))).click();				
	}
	
	
	public static void clickSubmenu_Index(WebDriver driver,String innerText,String  index){
		String xpath=SUBMENU_XPATH_INDEX.replace("text", innerText).replace("index", index);		
	    SeleniumUtil.getWebElement(driver, By.xpath(xpath)).click();
	
				
	}
	
	
	public static void  loginToApplication(WebDriver driver,String userName,String password){
		if (userName!=null){
			SeleniumUtil.getWebElement(driver, By.id(EMAIL_ID)).sendKeys(userName);;
		}
		if (password!=null){
			SeleniumUtil.getWebElement(driver, By.id(PASSWORD_ID)).sendKeys(password);
		}
		
		SeleniumUtil.getWebElement(driver, By.id(SIGNINBUTTON_ID)).click();
	}
	
	public static boolean checkSigninTitle(WebDriver driver){
		 return SeleniumUtil.checkPageTitle(driver, SIGNINTITLE);
		
	}

	public static String getErrorMessage(WebDriver driver){
		return  SeleniumUtil.getTextMessage(driver, By.id(ERRORMESSAGE_ID));
		 
		
	}
	

}


