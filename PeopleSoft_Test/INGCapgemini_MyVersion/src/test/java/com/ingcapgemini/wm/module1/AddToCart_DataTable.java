package com.ingcapgemini.wm.module1;

import org.apache.log4j.LogManager;

//import cucumber.api.Scenario;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.ingcapgemini.wm.common.GlobalStepDefinition;
import com.ingcapgemini.wm.pageobjectmodel.AddToCart_PO;
import com.ingcapgemini.wm.pageobjectmodel.ShoppingCartSummaryPage_PO;
import com.ingcapgemini.wm.pageobjectmodel.WelcomePage_PO;
import com.ingcapgemini.wm.util.SeleniumUtil;
import com.ingcapgemini.wm.util.Xls_Reader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCart_DataTable {

	private static final Logger LOGGER = LogManager.getLogger(AddToCart_DataTable.class);
	String item;
	String sku;
	Xls_Reader xlread = GlobalStepDefinition.xlread;
	

	
	@When("^user searches for an item DataTable$")
	public void user_searches_for_the_item() throws Throwable {
		
		LOGGER.info("########## Inside user_searches_for_the_item  ##########");

		
		String sheetName=GlobalStepDefinition.sheetName;
		int rowNum=GlobalStepDefinition.rowNum;
		item = xlread.getCellData(sheetName, "Item", rowNum);

		WelcomePage_PO.searchItem(item);
    
		SeleniumUtil.ValidateWebElementVisible(By.xpath(AddToCart_PO.AddToCart_ProductImage_XPATH.replace("ProductName", item)));

		LOGGER.debug("########## Search of the item (" + item + ") is successful ##########");
		// Assert.assertTrue("Object is NOT
		// displayed",SeleniumUtil.validateWebElementDisplay(By.xpath(AddToCart_PO.AddToCart_ProductImage_XPATH.replace("ProductName",
		// item))));
		// Assert.assertTrue("Object is NOT
		// displayed-Count-0",SeleniumUtil.validateWebElementCount(By.xpath(AddToCart_PO.AddToCart_ProductImage_XPATH.replace("ProductName",
		// item)))>0);

	}

	@And("^user Add To Cart and Proceed to checkout DataTable$")
	public void verify_item_is_present_addtocart_checkout() throws Throwable {

		LOGGER.info("##########  Inside verify_item_is_present_addtocart_checkout ##########");
		AddToCart_PO.clickProductImageFromSearchResult(item);
		AddToCart_PO.clickCheckOut();

	}

	@Then("^summary section shows the added item DataTable$")
	public void summary_section_shows_the_added_item() throws Throwable {
		LOGGER.info("##########  Inside summary_section_shows_the_added_item ##########");
		SeleniumUtil.ValidateWebElementPresence(By.cssSelector(
				ShoppingCartSummaryPage_PO.ShoppingCartSummary_ProductText_CSS.replace("ProductName", item)));
		LOGGER.debug("########## summary section shows the added item successfully ##########");
	}

	@When("^user delete the item DataTable$")
	public void user_delete_item() throws Throwable {
		LOGGER.info("########## Inside user_delete_item ##########");
		String sheetName=GlobalStepDefinition.sheetName;
		int rowNum=GlobalStepDefinition.rowNum;
		sku = xlread.getCellData(sheetName, "SKU", rowNum);

		ShoppingCartSummaryPage_PO.deleteItem(sku);
	}

	@Then("^added item should be removed DataTable$")
	public void added_item_should_be_removed() throws Throwable {
		LOGGER.info("##########  Inside added_item_should_be_removed ##########");
		SeleniumUtil.wait(5000);

		Assert.assertTrue("Item NOT deleted successfully", SeleniumUtil.validateWebElementCount(By.cssSelector(
				ShoppingCartSummaryPage_PO.ShoppingCartSummary_ProductText_CSS.replace("ProductName", item))) == 0);
		LOGGER.debug("########## Added item should removed successfully ##########");

	}

}
