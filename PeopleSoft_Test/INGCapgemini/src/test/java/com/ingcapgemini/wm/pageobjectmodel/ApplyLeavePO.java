package com.ingcapgemini.wm.pageobjectmodel;

import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ingcapgemini.wm.story.leave.ApplyLeave;
import com.ingcapgemini.wm.util.SeleniumUtil;

public class ApplyLeavePO {
	private static final Logger LOGGER=LogManager.getLogger(ApplyLeave.class);
	public static final String APPLYLEAVE__LEAVETYPE_ID="applyleave_txtLeaveType";
	public static final String APPLYLEAVE__FROMDATE_ID="applyleave_txtFromDate";
	public static final String APPLYLEAVE__TODATE_ID="applyleave_txtToDate";
	public static final String APPLYLEAVE__COMMENT_ID="applyleave_txtComment";
	public static final String APPLYLEAVE__APPLYBUTTON_ID="applyBtn";
	public static final String APPLYLEAVE__BROWSE_ID="applyleave_attachment";
	public static final String APPLYLEAVE__FILENAME_ID="applyleave_attachment";
	public static final String APPLYLEAVE__CONFIRMOKBUTTON_ID="confirmOkButton";
	public static final String APPLYLEAVE__MYLEAVE_ID="menu_leave_viewMyLeaveList";
	
	
	
	
	
	public static void applyLeave(WebDriver driver,String leaveType ,String fromDate,String toDate,String comment) throws Throwable{
		LOGGER.info("Inside ApplyLeavePO");
		
		if (leaveType!=null){
			SeleniumUtil.selectWebList(driver, By.id(APPLYLEAVE__LEAVETYPE_ID), leaveType, "selectByVisibleText");
			Thread.sleep(1000);
		}
		if (fromDate!=null){
			SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__FROMDATE_ID)).clear();
			SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__FROMDATE_ID)).sendKeys(fromDate);
			Thread.sleep(1000);
			
		}
		if (toDate!=null){
			SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__TODATE_ID)).clear();
			SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__TODATE_ID)).sendKeys(toDate);
			Thread.sleep(1000);
			SeleniumUtil.robotSendKeys(KeyEvent.VK_TAB);
			Thread.sleep(500);
		}
		if (comment!=null){
			SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__COMMENT_ID)).sendKeys(comment);
		}
		
		//Code will be given by Code....
		//SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__BROWSE_ID)).click();
		
		//SeleniumUtil.robotUploadFile("C:\\Users\\P\\Desktop\\offer.txt");
		
		
		
		Thread.sleep(10000);
		SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__APPLYBUTTON_ID)).click();
		Thread.sleep(1000);
		SeleniumUtil.getWebElement(driver, By.id(APPLYLEAVE__CONFIRMOKBUTTON_ID)).click();
		LOGGER.debug("####################### Leave Applied ############################");
	}
	
	
	

}
