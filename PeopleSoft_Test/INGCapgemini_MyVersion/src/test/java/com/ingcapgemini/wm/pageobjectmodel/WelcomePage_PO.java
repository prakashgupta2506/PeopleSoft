package com.ingcapgemini.wm.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.ingcapgemini.wm.util.SeleniumUtil;

public class WelcomePage_PO {
	public static final String WELCOMEPAGE_SIGNOUT_CSS="a.logout";// XPATH //a[contains(text(),'Sign out')]
	public static final String WELCOMEPAGE_SEARCH_ID="search_query_top";
	public static final String WELCOMEPAGE_SEARCH_CSS="button[name='submit_search']"; //XPATH "//button[@name='submit_search']"
	private static final Logger LOGGER=LogManager.getLogger(WelcomePage_PO.class);
	public static final String CREATEDUSERNAME_XPATH="//a[@title='View my customer account']/span";
	public static void clickSignOut(){
		LOGGER.info("######  Inside clickSignOut ##############");
		SeleniumUtil.clickWebElement(By.cssSelector(WELCOMEPAGE_SIGNOUT_CSS));
		
	}
	
	public static void searchItem(String item){
		
		LOGGER.info("######  Inside searchItem ##############");
		SeleniumUtil.setValue(By.id(WELCOMEPAGE_SEARCH_ID), item);
		SeleniumUtil.clickWebElement(By.cssSelector(WELCOMEPAGE_SEARCH_CSS));
		
		
	}

}
