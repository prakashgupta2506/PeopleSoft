package com.ingCapgemini.testngproject.pagefactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class AccountPage  {

	public static final String AccountTab_xpath="//a[@title='Accounts Tab']";
	@FindBy(xpath=AccountTab_xpath)
	private WebElement Accounttab;
	
	public static final String NewButton_xpath="//input[@name='new']";
	@FindBy(xpath=NewButton_xpath)
	private WebElement newbutton;
	
	public static final String AccountName_text_id="acc2";
	@FindBy(id=AccountName_text_id)
	private WebElement accountName;
	
	
	public static final String type_select_id="acc6";
	@FindBy(id=type_select_id)
	private WebElement typeselect;
	
	
	public static final String saveButton_xapth="(//input[@name='save'])[position()=2]";
	@FindBy(xpath=saveButton_xapth)
	private WebElement savebutton;
	
	
	public static final String ParentAccount_window_xpath="//img[@class='lookupIcon']";//we can use //a[@id='acc3_lkwgt']/img
	@FindBy(xpath=ParentAccount_window_xpath)
	private WebElement parentAccountlookup;
	
	public static final String selectparentaccount_xpath="//a[contains(text(),'";
	
	public static final String afteraccount_create_xpath="//div[contains(text(),'";
	
	public	AccountPage(WebDriver driver){
	
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getaccountab(){
		return Accounttab;
	}
   
	public void clickaccount(){
		Accounttab.click();
	}
	
	public void clicknewbutton(){
		newbutton.click();
		
	}
	
	public boolean  createaccount(WebDriver driver,String name,String text,String parentacct) throws InterruptedException{
		
		
		Thread.sleep(2000);
		Accounttab.click();
		  Thread.sleep(2000);
		newbutton.click();
		Thread.sleep(1000);
		accountName.sendKeys(name);
		Select sel=new Select(typeselect);
		sel.selectByVisibleText(text);
		parentAccountlookup.click();
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String parent=it.next();
		String child=it.next();
		
		driver.switchTo().window(child);
		driver.switchTo().frame("resultsFrame");
		System.out.println("the parent account number"+parentacct);
		String selectparentaccount=selectparentaccount_xpath+parentacct+"')]";
		System.out.println("parent xapth"+selectparentaccount);
		driver.findElement(By.xpath(selectparentaccount)).click();
		driver.switchTo().window(parent);
		savebutton.click();
		
		Thread.sleep(2000);
		
		
		
		return true;
	}
}
