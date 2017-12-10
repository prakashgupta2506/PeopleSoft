package com.ingcapgemini.wm.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ingcapgemini.wm.story.leave.ApplyLeave;
import com.ingcapgemini.wm.util.SeleniumUtil;

public class HomePage {
	private static final Logger LOGGER=LogManager.getLogger(ApplyLeave.class);
	public static final String HOME_PAGE_WELCOME_ID="welcome";
	public static final String HOME_PAGE_LEAVE_LINK_XPATH="//a/b[contains(text(),'Leave')]";
	public static final String HOME_PAGE_APPLY_ID="menu_leave_applyLeave";
	
	
	public static void clickLeaveApply(WebDriver driver) throws Throwable{
		SeleniumUtil.getWebElement(driver, By.xpath(HOME_PAGE_LEAVE_LINK_XPATH)).click();
		Thread.sleep(1000);
		SeleniumUtil.getWebElement(driver, By.id(HOME_PAGE_APPLY_ID)).click();		
		
	}
	

}


